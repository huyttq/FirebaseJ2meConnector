/**
 * Copyright (C) 2011 Cubeia Ltd <info@cubeia.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.cubeia.firebase.clients.java.connector;

import com.cubeia.firebase.api.util.Arguments;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.StyxSerializer;
import com.cubeia.firebase.io.protocol.ProtocolObjectFactory;
import com.jmobilecore.comm.BufferedInputStream;
import com.jmobilecore.comm.BufferedOutputStream;
import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicBoolean;
import j2me.nio.ByteBuffer;
import j2me.util.logging.Level;
import java.io.*;
import java.security.GeneralSecurityException;
import javax.microedition.io.Connector;
import javax.microedition.io.SecureConnection;
import javax.microedition.io.SocketConnection;

public class SocketConnector extends ConnectorBase {

	private final StyxSerializer styx = new StyxSerializer(new ProtocolObjectFactory());
	private SocketConnection socket;
	private StreamReader reader;
	private StreamWriter writer;
	private final Encryption encryption;
	
	private final String host;
	private final int port;
	// use OutputStream to send requests
	private DataOutputStream dataOutputStream = null;
	// use InputStream to receive responses from server
	private DataInputStream dataInputStream = null;

	/**
	* @param host Host to connect to, must not be null
	* @param port Port to connect to, must be > 0
	* @param listener Initial listener, may be null
	* @param encryption Encryption to use, or null for none
	* @param useHandshake True if handshake should be used, false otherwise
	* @param handshakeSignature Handshake to use if "useHandshake" is true
	* @throws IOException On general IO errors
	* @throws GeneralSecurityException On SSL errors
	*/
	public SocketConnector(String host, int port, PacketListener listener, Encryption encryption, boolean useHandshake, int handshakeSignature) throws IOException, GeneralSecurityException {
		super(useHandshake, handshakeSignature);
		Arguments.notNull(host, "host");
		if (listener != null) {
			addListener(listener);
		}
		this.encryption = (encryption == null ? Encryption.NONE : encryption);
		this.host = host;
		this.port = port;
	}

/**
	* @param host Host to connect to, must not be null
	* @param port Port to connect to, must be > 0
	* @param encryption Encryption to use, or null
	* @param useHandshake True if handshake should be used, false otherwise
	* @param handshakeSignature Handshake to use if "useHandshake" is true
	* @throws IOException On general IO errors
	* @throws GeneralSecurityException On SSL errors
	*/
	public SocketConnector(String host, int port, Encryption encryption, boolean useHandshake, int handshakeSignature) throws IOException, GeneralSecurityException {
		this(host, port, null, encryption, useHandshake, handshakeSignature);
	}

/**
	* @param host Host to connect to, must not be null
	* @param port Port to connect to, must be > 0
	* @param encryption Encryption to use, or null
	* @throws IOException On general IO errors
	* @throws GeneralSecurityException On SSL errors
	*/
	public SocketConnector(String host, int port, Encryption encryption) throws IOException, GeneralSecurityException {
		this(host, port, null, encryption, false, -1);
	}

/**
	* @param host Host to connect to, must not be null
	* @param port Port to connect to, must be > 0
	* @throws IOException On general IO errors
	* @throws GeneralSecurityException On SSL errors
	*/
	public SocketConnector(String host, int port) throws IOException, GeneralSecurityException {
		this(host, port, null, Encryption.NONE, false, -1);
	}

/**
	* This object waits for the session key to arrive when created
	* with native firebase encryption enabled. This method specifies
	* the default wait for the session key in milliseconds. Set to -1
	* to disable waiting.
	* 
	* @param millis Millis to wait for session key, or -1 for no wait
	
	public void setKeyExchangeWait(long millis) {
		this.keyExchangeWait = millis;
	}*/

	/*
	 * (non-Javadoc)
	 * @see
	 * com.cubeia.firebase.clients.java.connector.Connector#connect()
	 */
	public void connect() throws IOException, GeneralSecurityException {
		try {
			socket = createSocket(host, port);
		} catch (Exception ex) {
		}
		dataInputStream = new DataInputStream(socket.openInputStream());
		reader = new StreamReader(dataInputStream);

		dataOutputStream = new DataOutputStream(socket.openDataOutputStream());
		writer = new StreamWriter(dataOutputStream);

		reader.start();
		checkSendHandshake();
		//checkSendKeyExchange();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.cubeia.firebase.clients.java.connector.Connector#send(com.cubeia.firebase.io.ProtocolObject)
	 */
	public void send(ProtocolObject packet) {
		Arguments.notNull(packet, "packet");
		writer.sendPacket(packet);
	}

	public ProtocolObject read() throws IOException {
		return reader.readPacket();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.cubeia.firebase.clients.java.connector.Connector#disconnect()
	 */
	public void disconnect() {
		dispatcher.complete();
		reader.close();
		writer.close();
		closeSocket();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.cubeia.firebase.clients.java.connector.Connector#isConnected()
	 */
	public boolean isConnected() {
		return (socket != null);
	}

	protected void handleReadException(Exception e) {
		if (e instanceof IOException) {
			if (e instanceof EOFException) {
				log.log(Level.SEVERE, "Remote connection closed");
			} else {
				log.log(Level.SEVERE, "Faile to read packet", e);
			}
		} else if (e instanceof GeneralSecurityException) {
			log.log(Level.SEVERE, "General security error", e);
		} else {
			log.log(Level.SEVERE, "Unknown error", e);
		}
	}

	private void checkSendHandshake() throws IOException {
		if (useHandshake) {
			writer.sendHandshake();
		}
	}

	private void closeSocket() {
		try {
			socket.close();
		} catch (Exception e) {
			log.log(Level.SEVERE, "Failed to close connector", e);
		}
	}

	private void dispatch(final ProtocolObject packet) throws IOException, GeneralSecurityException {
		doFinalDispatch(packet);
	}

	private void doFinalDispatch(final ProtocolObject packet) {
		dispatcher.assign(new Runnable() {

			public void run() {
				for (int i = 0; i < listeners.size(); i++) {
					PacketListener v = (PacketListener) listeners.get(i);
					v.packetRecieved(packet);
				}
			}
		});
	}

	private SocketConnection createSocket(String host, int port) throws IOException, GeneralSecurityException, Exception {
		SocketConnection conn;
		if (encryption == Encryption.NAIVE_SSL || encryption == Encryption.SSL) {
			conn = (SecureConnection) Connector.open("ssl://" + host + ":" + port);
		} else {
			conn = (SocketConnection) Connector.open("socket://" + host + ":" + port);						
		}
		conn.setSocketOption(SocketConnection.DELAY, 0);
		conn.setSocketOption(SocketConnection.KEEPALIVE, 0);
		return conn;
	}

	// --- PRIVATE CLASSES --- //
	private class StreamReader extends Thread {

		private final DataInputStream in;
		private final AtomicBoolean flag;

		private StreamReader(InputStream stream) {
			in = new DataInputStream(new BufferedInputStream(stream));
			flag = new AtomicBoolean(true);
		}

		public void run() {
			doRead();
			try {
				doClose();
			} catch (IOException ex) {
			}
		}

		public void close() {
			flag.set(false);
		}

		// --- PRIVATE METHODS --- //
		private void doClose() throws IOException {
			in.close();
		}

		private void doRead() {
			try {
				while (flag.get()) {
					ProtocolObject packet = readPacket();
					if (packet != null) {
						dispatch(packet);
					}
				}
			} catch (Exception e) {
				handleReadException(e);
			}
		}

		private ProtocolObject readPacket() throws IOException {
			int len = in.readInt();
			if (!flag.get()) {
				return null;
			}
			byte[] arr = new byte[len - 4];
			in.readFully(arr);
			if (!flag.get()) {
				return null;
			}
			return unpack(len, arr);
		}

		private ProtocolObject unpack(int len, byte[] arr) throws IOException {
			ByteBuffer buf = toByteBuffer(len, arr);
			return styx.unpack(buf);
		}

		private ByteBuffer toByteBuffer(int len, byte[] arr) {
			ByteBuffer buf = ByteBuffer.allocateDirect(len);
			buf.putInt(len);
			buf.position(buf.position() + 3);
			buf.put(arr);
			buf.rewind();
			return buf;
		}
	}

	private class StreamWriter {

		private DataOutputStream out;

		private StreamWriter(OutputStream stream) {
			out = new DataOutputStream(new BufferedOutputStream(stream));
		}

		public void close() {
			try {
				out.close();
			} catch (IOException ex) {
				//TODO
			}
		}

		public void sendPacket(ProtocolObject packet) {
			try {
				ByteBuffer buffer = styx.pack(packet);
				byte[] array = buffer.array();
				out.write(array);
				out.flush();
			} catch (Exception ex) {
				log.log(Level.SEVERE, "Faile to write packet", ex);
			}
		}

		public void sendHandshake() throws IOException {
			out.writeInt(handshakeSignature);
			out.flush();
		}
	}
}