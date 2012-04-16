/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package huy.test;

import com.cubeia.firebase.clients.java.connector.CryptoConstants;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.*;
import javax.crypto.Cipher;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
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
		String text = "This is a long secret content.This is a long secret content.This is a long secret content.This is a long secret content.This is a long secret content.";
		byte[] result = crypto.encrypt(text.getBytes(), keyPair.getPublic());
		System.out.println("encrypted string:" + new String(result));
		byte[] decryptedBytes = crypto.decrypt(result, keyPair.getPrivate());
		
		System.out.println("decrypted string: " + new String(decryptedBytes));
		assertEquals(text, new String(decryptedBytes));
	}

	@Test
	public void decryptJ2SECompatible() throws GeneralSecurityException {
		AsymmetricCipherKeyPair keyPair = RSACryptoProvider.generateRSAKey();
		
		String text = "12345678901234567890123456712345678901234567890123456";
		System.out.println("encrypt data on server side, text length: " + text.length());
		
		RSAKeyParameters pubKey = (RSAKeyParameters)keyPair.getPublic();
		RSAPrivateCrtKeyParameters priKey = (RSAPrivateCrtKeyParameters)keyPair.getPrivate();
		
		RSAPublicKeySpec spec = new RSAPublicKeySpec(new BigInteger(pubKey.getModulus().toString(16), 16), new BigInteger(pubKey.getExponent().toString(16), 16));
		
		KeyFactory kf = KeyFactory.getInstance("RSA");		
		Cipher cipher = Cipher.getInstance("RSA");		
		cipher.init(Cipher.ENCRYPT_MODE, kf.generatePublic(spec));		
		byte[] encrypted = cipher.doFinal(text.getBytes());
		
		RSAPrivateCrtKeySpec privateSec = new RSAPrivateCrtKeySpec(new BigInteger(pubKey.getModulus().toByteArray()), new BigInteger(pubKey.getExponent().toByteArray()),
																															new BigInteger(priKey.getExponent().toByteArray()), new BigInteger(priKey.getP().toByteArray()), 
																															new BigInteger(priKey.getQ().toByteArray()), new BigInteger(priKey.getDP().toByteArray()), 
																															new BigInteger(priKey.getDQ().toByteArray()), new BigInteger(priKey.getQInv().toByteArray()));
		
		cipher.init(Cipher.DECRYPT_MODE, kf.generatePrivate(privateSec));
		String result = new String(cipher.doFinal(encrypted));
		System.out.println("Decrypted string by j2se: " + result);
		
		RSACryptoProvider crypto = new RSACryptoProvider();
		byte[] decryptedBytes = crypto.decrypt(encrypted, keyPair.getPrivate());
		
		System.out.println("Decrypted string: " + new String(decryptedBytes) + " with length: " + (new String(decryptedBytes)).length());
		assertEquals(true, (new String(decryptedBytes)).contains(text));
	}	
	
	@Test
	public void decryptJ2SECompatible2() throws GeneralSecurityException {
		AsymmetricCipherKeyPair keyPair = RSACryptoProvider.generateRSAKey();		
		String text = "Hello world!";
		System.out.println("encrypt data on server side, text length: " + text.length());
		
		RSACryptoProvider crypto = new RSACryptoProvider();
		byte[] encrypted = crypto.encrypt(text.getBytes(), keyPair.getPublic());

		RSAKeyParameters pubKey = (RSAKeyParameters)keyPair.getPublic();
		RSAPublicKeySpec spec = new RSAPublicKeySpec(new BigInteger(pubKey.getModulus().toByteArray()), new BigInteger(pubKey.getExponent().toByteArray()));
		KeyFactory kf = KeyFactory.getInstance("RSA");		
		Cipher cipher = Cipher.getInstance("RSA");		
		cipher.init(Cipher.ENCRYPT_MODE, kf.generatePublic(spec));		
		byte[] encrypted2 = cipher.doFinal(text.getBytes());
		/*RSAKeyParameters priKey = (RSAKeyParameters)keyPair.getPrivate();		
		
		RSAPrivateKeySpec privateSec = new RSAPrivateKeySpec(new BigInteger(priKey.getModulus().toString(16), 16), new BigInteger(priKey.getExponent().toString(16), 16));		
		KeyFactory kf = KeyFactory.getInstance("RSA");		
		Cipher cipher = Cipher.getInstance("RSA");		
		cipher.init(Cipher.DECRYPT_MODE, kf.generatePrivate(privateSec));
		
		byte[] decryptedBytes = cipher.doFinal(encrypted);
		
		System.out.println("Decrypted string by j2se: " + new String(decryptedBytes));*/
		System.out.println("Decrypted string by j2se: " + new String(encrypted));
		System.out.println("Decrypted string by bc: " + new String(encrypted2));
		assertEquals(new String(encrypted2), new String(encrypted));
	}
	
	@Test
	public void decryptJ2SECompatible3() throws GeneralSecurityException {
		AsymmetricCipherKeyPair keyPair = RSACryptoProvider.generateRSAKey();		
		
		RSAKeyParameters pubKey = (RSAKeyParameters)keyPair.getPublic();
		RSAKeyParameters priKey = (RSAKeyParameters)keyPair.getPrivate();
		System.out.println("public key: " + pubKey.getModulus() + " exponent: " + pubKey.getExponent());
		System.out.println("private key: " + priKey.getModulus() + " exponent: " + priKey.getExponent());

		RSAPublicKeySpec spec = new RSAPublicKeySpec(new BigInteger(pubKey.getModulus().toByteArray()), new BigInteger(pubKey.getExponent().toByteArray()));
		RSAPrivateKeySpec privateSec = new RSAPrivateKeySpec(new BigInteger(priKey.getModulus().toByteArray()), new BigInteger(priKey.getExponent().toByteArray()));
		
		KeyFactory kf = KeyFactory.getInstance("RSA");		
		PublicKey pubKey2 = kf.generatePublic(spec);	
		PrivateKey privateKey2 = kf.generatePrivate(privateSec);

		System.out.println("public key2 : " + pubKey2.toString());
		System.out.println("private key2 : " + privateKey2.toString());
	}
}
