/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package huy.test;

import com.cubeia.firebase.clients.java.connector.CryptoConstants;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAKeyGenParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.huy.firebase.clients.j2me.connector.RSACryptoProvider;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRSACryptoProvider {

	public TestRSACryptoProvider() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Test
	public void generateRSAKeyPair() throws UnsupportedEncodingException, GeneralSecurityException {
		System.out.println("generate RSA key pair");
		AsymmetricCipherKeyPair j2meKeyPair = RSACryptoProvider.generateRSAKey();
		String j2mePublicKey = ((RSAKeyParameters) j2meKeyPair.getPublic()).getModulus().toString(16);
		System.out.println("j2me public key: " + j2mePublicKey);

		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		RSAKeyGenParameterSpec spec = new RSAKeyGenParameterSpec(CryptoConstants.RSA_KEY_SIZE, CryptoConstants.RSA_KEY_EXPONENT);
		generator.initialize(spec);
		KeyPair j2seKeyPair = generator.generateKeyPair();
		String j2sePublicKey = ((RSAPublicKey) j2seKeyPair.getPublic()).getModulus().toString(16);
		System.out.println("j2se public key: " + j2sePublicKey);
		assertEquals(j2mePublicKey.length(), j2sePublicKey.length());
	}

	@Test
	public void encryptAndDecrypt() throws GeneralSecurityException {
		System.out.println("encrypt using RSA");
		AsymmetricCipherKeyPair keyPair = RSACryptoProvider.generateRSAKey();
		RSACryptoProvider crypto = new RSACryptoProvider();
		String text = "This is a secret content";
		byte[] result = crypto.encrypt(text.getBytes(), keyPair.getPublic());
		System.out.println("encrypted string:" + new String(result));
		byte[] decryptedBytes = crypto.decrypt(result, keyPair.getPrivate());
		assertEquals(text, new String(decryptedBytes));
	}

	@Test
	public void decryptJ2SECompatible() throws GeneralSecurityException {
		AsymmetricCipherKeyPair keyPair = RSACryptoProvider.generateRSAKey();
		System.out.println("encrypt data on server side");
		String text = "This is a secret content";
		
		byte[] publickKey = ((RSAKeyParameters)keyPair.getPublic()).getModulus().toString(16).getBytes();
		
		X509EncodedKeySpec spec = new X509EncodedKeySpec(publickKey);
		KeyFactory kf = KeyFactory.getInstance("RSA");		
		Cipher cipher = Cipher.getInstance("RSA");		
		//TODO: Find a way to convert plain string to public key
		cipher.init(Cipher.ENCRYPT_MODE, kf.generatePublic(spec));
		
		byte[] decrypted = cipher.doFinal(text.getBytes());
		
		RSACryptoProvider crypto = new RSACryptoProvider();
		byte[] result = crypto.encrypt(decrypted, keyPair.getPublic());
		
		byte[] decryptedBytes = crypto.decrypt(result, keyPair.getPrivate());
		assertEquals(text, new String(decryptedBytes));
	}	
}
