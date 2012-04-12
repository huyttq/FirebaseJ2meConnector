/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package huy.test;

import com.cubeia.firebase.clients.java.connector.SessionKey;
import java.io.UnsupportedEncodingException;
import org.huy.firebase.clients.j2me.connector.AESCryptoProvider;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author
 * Linh
 */
public class TestAESCryptoProvider {
	
	public TestAESCryptoProvider() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	/**
	 * Test of pricePerMonth method, of class Test.
	 */
	@Test
	public void encryptAndDecrypt() throws UnsupportedEncodingException {
		System.out.println("encrypt and descrypt using AES");
		AESCryptoProvider crytoProvider = new AESCryptoProvider();
		SessionKey key = new SessionKey("secret1234567890".getBytes());		
		crytoProvider.setSessionKey(key);
		
		String stringToConvert = "This String is 76 characters long and will be converted to an array of bytes";
		byte[] byteArray = stringToConvert.getBytes();
		byte[] encryptedBytes = crytoProvider.encrypt(byteArray);
		System.out.println("Encrypted string: " + new String(encryptedBytes));
		byte[] decryptedBytes = crytoProvider.decrypt(encryptedBytes);
		String decryptStr = new String(decryptedBytes);
		System.out.println("Decrypted string: " + new String(decryptedBytes));
		
		assertEquals(stringToConvert, decryptStr);
	}
}
