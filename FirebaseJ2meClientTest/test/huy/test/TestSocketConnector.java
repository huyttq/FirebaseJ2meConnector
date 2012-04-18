/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package huy.test;

import com.cubeia.firebase.io.protocol.LoginRequestPacket;
import com.cubeia.firebase.io.protocol.LoginResponsePacket;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import org.huy.firebase.clients.j2me.connector.LoginListener;
import org.huy.firebase.clients.j2me.connector.SocketConnector;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author
 * Linh
 */
public class TestSocketConnector {

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Test
	public void connect() throws UnsupportedEncodingException, IOException, GeneralSecurityException {
		int port = 4123;
		String host = "localhost";

		SocketConnector connector = new SocketConnector(host, port);
		connector.connect();

		LoginListener listener = new LoginListener();
		connector.addListener(listener);
		LoginRequestPacket pak = new LoginRequestPacket();
		pak.user = "test";
		pak.password = "1234";
		pak.operatorid = 0;
		connector.send(pak);

		LoginResponsePacket re = null;
		try {
			while(re == null) {
				re = (LoginResponsePacket) connector.read();
			} 
		}catch (Exception ex) {
		}
		
		LoginResponsePacket result = (LoginResponsePacket) listener.loginPacket;
		connector.disconnect();
		assertEquals("1234", result.pid);
	}
}
