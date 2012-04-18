/**
 * Copyright
 * 2009
 * Cubeia
 * Ltd
 *
 * Licensed
 * under
 * the
 * Apache
 * License,
 * Version
 * 2.0
 * (the
 * "License");
 * you
 * may
 * not
 * use
 * this
 * file
 * except
 * in
 * compliance
 * with
 * the
 * License.
 * You
 * may
 * obtain
 * a
 * copy
 * of
 * the
 * License
 * at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless
 * required
 * by
 * applicable
 * law
 * or
 * agreed
 * to
 * in
 * writing,
 * software
 * distributed
 * under
 * the
 * License
 * is
 * distributed
 * on
 * an
 * "AS
 * IS"
 * BASIS,
 * WITHOUT
 * WARRANTIES
 * OR
 * CONDITIONS
 * OF
 * ANY
 * KIND,
 * either
 * express
 * or
 * implied.
 * See
 * the
 * License
 * for
 * the
 * specific
 * language
 * governing
 * permissions
 * and
 * limitations
 * under
 * the
 * License.
 */
package com.cubeia.firebase.io;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import j2me.nio.ByteBuffer;

/**
 * The
 * styx
 * wire
 * protocol
 * serializer/deserializer.
 * This
 * class
 * is
 * the
 * primary
 * interface
 * to
 * be
 * used
 * by
 * users
 * of
 * the
 * Styx
 * wire
 * protocol.
 */
public final class StyxSerializer {

	/**
	 * Bah.
	 * When
	 * in
	 * rome...
	 */
	public static int HEADER_SIZE = 4;

	/**
	 * Initialize
	 * this
	 * class
	 * with
	 * the
	 * automatically
	 * generated
	 * ObjectFactory
	 */
	public StyxSerializer(ObjectFactory factory) {
		this.factory = factory;
	}

	/**
	 * Unpack
	 * a
	 * byte
	 * sequence
	 * into
	 * a
	 * concrete
	 * ProtocolObject.
	 */
	public ProtocolObject unpack(ByteBuffer inBuffer) throws IOException {
		int payloadLength = inBuffer.getInt();
		inBuffer.position(inBuffer.position() + 3);

		// Styx by default uses length exclusive from the length header
		if (inBuffer.remaining() < payloadLength - HEADER_SIZE) {
			throw new IllegalStateException("Packet not fully read! Want " + payloadLength + " bytes, available: " + inBuffer.remaining());
		}

		int classId = BinaryData.asUnsigned(inBuffer.get());
		ProtocolObject po = factory.create(classId);
		po.load(new PacketInputStream(inBuffer));

		return po;
	}

	public byte[] packArray(ProtocolObject obj) throws IOException {
		if (obj.classId() > 255 || obj.classId() < 0) {
			throw new IllegalArgumentException("classId " + obj.classId() + " is out of range. Legal values are inside a signed byte.");
		}
		byte[] packed = packObject(obj); // 5 bytes free at the start
		writeLengthHeader(packed.length, packed); // write length, 4 bytes
		writeClassidHeader(obj, packed); // write class id, 1 byte
		return packed;
	}

	public ByteBuffer pack(ProtocolObject obj) throws IOException {
		return ByteBuffer.wrap(packArray(obj));



		/*
		 * ByteBuffer
		 * buf
		 * =
		 * ByteBuffer.allocate(4+1+packed.length);
		 * //
		 * Size+type+payload
		 * //
		 * buf.putShort((short)(1+2+packed.length));
		 * buf.putInt(4+1+packed.length);
		 * //
		 * Size+type+payload
		 * buf.put((byte)obj.classId());
		 * buf.put(packed);
        buf.rewind();
		 */

//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        DataOutputStream dos = new DataOutputStream(bos);
//        dos.writeShort(1 + 2 + packed.length);
//        dos.writeByte(obj.classId());
//        dos.write(packed, 0, packed.length);
//        dos.flush();


		// return buf;
	}

	private void writeClassidHeader(ProtocolObject obj, byte[] bytes) {
		bytes[4] = (byte) obj.classId();
	}

	private void writeLengthHeader(int value, byte[] bytes) {
		int len = 4;
		for (int i = 0; i < len; i++) {
			bytes[len - 1 - i] = (byte) (value & 0xff);
			value >>= 8;
		}
	}

	/**
	 * This
	 * method
	 * returns
	 * a
	 * byte
	 * array
	 * with
	 * 5
	 * bytes
	 * free
	 * at
	 * the
	 * start
	 * (written
	 * as
	 * zeroes)
	 * for
	 * the
	 * packet
	 * header
	 * (size+classid).
	 */
	private byte[] packObject(ProtocolObject obj) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream(37);
		for (int i = 0; i < 5; i++) {
			// write header bytes...
			bos.write(0);
		}
		packObject(obj, bos);
		return bos.toByteArray();
	}

	private void packObject(ProtocolObject obj, ByteArrayOutputStream bos) throws IOException {
		DataOutputStream dos = new DataOutputStream(bos);
		PacketOutputStream pos = new PacketOutputStream(dos);
		obj.save(pos);
		dos.flush();
	}
	private final ObjectFactory factory;
}
