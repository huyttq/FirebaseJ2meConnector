/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.huy.firebase.clients.j2me.connector;

import java.util.ArrayList;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.RSAEngine;

/**
 *
 * @author
 * Linh
 */
public class RSACryptoProvider {
	private CipherParameters key;
	
	public RSACryptoProvider(CipherParameters key) {
		this.key = key;
	}
	
	public byte[] decrypt(byte[] data) {
		RSAEngine engine = new RSAEngine();		
		engine.init(false, key);
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

	private byte[] processResult(ArrayList result, int totalLength) {
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
