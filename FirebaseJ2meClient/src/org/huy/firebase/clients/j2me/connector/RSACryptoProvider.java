/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.huy.firebase.clients.j2me.connector;

import com.cubeia.firebase.clients.java.connector.CryptoConstants;
import java.security.GeneralSecurityException;
import j2me.security.SecureRandom;
import j2me.util.ArrayList;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.RSAEngine;
import org.bouncycastle.crypto.generators.RSAKeyPairGenerator;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;

/**
 *
 * @author
 * Linh
 */
public class RSACryptoProvider {
	private RSAEngine engine;
	
	public RSACryptoProvider() {
		this.engine = new RSAEngine();		
	}
	
	public byte[] decrypt(byte[] data, CipherParameters privateKey) {
		return process(data, false, privateKey);
	}
	
	public byte[] encrypt(byte[] data, CipherParameters publicKey) {
		return process(data, true, publicKey);
	}
	
	public static AsymmetricCipherKeyPair generateRSAKey() throws GeneralSecurityException {
		RSAKeyPairGenerator generator = new RSAKeyPairGenerator();
		SecureRandom sr = new SecureRandom();
		RSAKeyGenerationParameters spec = new RSAKeyGenerationParameters(CryptoConstants.RSA_KEY_EXPONENT, sr, CryptoConstants.RSA_KEY_SIZE, 80);
		generator.init(spec);		
		return generator.generateKeyPair();
	}

	private byte[] process(byte[] data, boolean encrypt, CipherParameters key){
		engine.init(encrypt, key);
		int blockSize = engine.getInputBlockSize();
		int length = blockSize;
		int offset = 0;
		ArrayList result = new ArrayList();
		int outputLength = 0;
		
		while(offset < data.length) {
			if( offset + length > data.length) {
				length = data.length - offset;
			}
			
			byte[] hexEncodedCipher = engine.processBlock(data, offset, length);
			outputLength += hexEncodedCipher.length;
			result.add(hexEncodedCipher);
			offset += blockSize;
		}		
		return processResult(result, outputLength);
	}
	
	private static byte[] processResult(ArrayList result, int totalLength) {
		byte[] output = new byte[totalLength];
		int curPos = 0;
		for(int i = 0; i < result.size(); i++) {
			byte[] block = ((byte[])result.get(i));			
			int blockSize = block.length;
			System.arraycopy(block, 0, output, curPos, blockSize);
			curPos += blockSize;
		}
		return output;
	}
}
