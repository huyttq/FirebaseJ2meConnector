/**
 * Copyright 2009 Cubeia Ltd  
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cubeia.firebase.io;

import j2me.nio.ByteBuffer;
import java.io.IOException;

/**
 * Handles the deserialization of the Styx wire format.
 */
public final class PacketInputStream {

	private final ByteBuffer inBuffer;

	public PacketInputStream(ByteBuffer inBuffer) {
		this.inBuffer = inBuffer;
	}

	public byte loadByte() throws IOException {
		return inBuffer.get();
	}

	public int loadUnsignedByte() throws IOException {
		return BinaryData.asUnsigned(inBuffer.get());
	}

	public int loadUnsignedShort() throws IOException {
		return BinaryData.asUnsigned(loadShort());
	}

	public short loadShort() throws IOException {
		short result = inBuffer.getShort();
		inBuffer.position(inBuffer.position() + 1);
		return result;
	}

	public int loadInt() throws IOException {
		int result = inBuffer.getInt();
		inBuffer.position(inBuffer.position() + 3);
		return result;
	}

	public long loadUnsignedInt() {
		long uint = 0;
		uint = uint | inBuffer.get() << 24;
		uint = uint | inBuffer.get() << 16;
		uint = uint | inBuffer.get() << 8;
		uint = uint | inBuffer.get();
		return uint;
	}

	public boolean loadBoolean() throws IOException {
		return (inBuffer.get() != 0);
	}

	public String loadString() throws IOException {
		int length = 0xffff & loadShort();
		byte[] utf8 = new byte[length];
		inBuffer.get(utf8);
		return new String(utf8, "UTF-8");
	}

	public void loadByteArray(byte[] arg0) throws IOException {
		inBuffer.get(arg0);
	}

	public void loadIntArray(int[] data) throws IOException {
		for (int i = 0; i < data.length; i++) {
			data[i] = loadInt();
		}
	}

	public void loadStringArray(String[] removedParams) throws IOException {
		for (int i = 0; i < removedParams.length; i++) {
			removedParams[i] = loadString();
		}
	}

	public long loadLong() {
		long result = inBuffer.getLong();
		inBuffer.position(inBuffer.position() + 7);
		return result;
	}
}
