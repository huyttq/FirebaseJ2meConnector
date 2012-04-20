package com.cubeia.firebase.clients.java.connector;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/**
 * @author
 * Huy Thai
 */
public class AESCryptoProvider implements CryptoProvider {

	private SessionKey sessionKey;
	private BufferedBlockCipher bufferedBlockCipher;
	private CipherParameters cipherParams;

	public AESCryptoProvider() {	
		
		BlockCipher blockCipher = new CBCBlockCipher(new AESEngine());
		BlockCipherPadding blockCipherPadding = new PKCS7Padding();

		this.bufferedBlockCipher = new PaddedBufferedBlockCipher(blockCipher, blockCipherPadding);
	}

	public byte[] encrypt(byte[] clearTextData) {
		if (sessionKey == null) {
			throw new RuntimeException("SESSION KEY IS NULL, CANNOT DECRYPT PACKET.");
		}
		try {
			return process(clearTextData, this.bufferedBlockCipher, this.cipherParams, true);
		} catch (InvalidCipherTextException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public byte[] decrypt(byte[] clearTextData) {
		if (sessionKey == null) {
			throw new RuntimeException("SESSION KEY IS NULL, CANNOT DECRYPT PACKET.");
		}
		try {
			return process(clearTextData, this.bufferedBlockCipher, this.cipherParams, false);
		} catch (InvalidCipherTextException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public void setSessionKey(SessionKey sessionKey) {
		this.sessionKey = sessionKey;
		byte[] iv = new byte[16];
		this.cipherParams = new ParametersWithIV(new KeyParameter(sessionKey.getEncoded()), iv);
	}

	public SessionKey getSessionKey() {
		return sessionKey;
	}

	public void createSessionKey() throws SecurityException {
		throw new UnsupportedOperationException();
	}

	private byte[] process(byte[] input, BufferedBlockCipher bufferedBlockCipher, CipherParameters cipherParameters, boolean forEncryption) throws InvalidCipherTextException {
		bufferedBlockCipher.init(forEncryption, cipherParameters);

		int inputOffset = 0;
		int inputLength = input.length;

		int maximumOutputLength = bufferedBlockCipher.getOutputSize(inputLength);
		byte[] output = new byte[maximumOutputLength];
		int outputOffset = 0;
		int outputLength = 0;

		int bytesProcessed;

		bytesProcessed = bufferedBlockCipher.processBytes(input, inputOffset, inputLength, output, outputOffset);
		outputOffset += bytesProcessed;
		outputLength += bytesProcessed;

		bytesProcessed = bufferedBlockCipher.doFinal(output, outputOffset);
		outputOffset += bytesProcessed;
		outputLength += bytesProcessed;

		if (outputLength == output.length) {
			return output;
		} else {
			byte[] truncatedOutput = new byte[outputLength];
			System.arraycopy(output, 0, truncatedOutput, 0, outputLength);
			return truncatedOutput;
		}
	}
}
