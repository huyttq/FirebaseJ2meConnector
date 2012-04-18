// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:15 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Param.java
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import com.cubeia.firebase.styx.util.ArrayUtils;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor
public final class Param implements ProtocolObject, Visitable {

	public int classId() {
		return 5;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public String key;
	public byte type;
	public byte[] value = new byte[0];

	/**
	 * Default
	 * constructor.
	 *
	 */
	public Param() {
		// Nothing here
	}

	public Param(String key, byte type, byte[] value) {
		this.key = key;
		this.type = type;
		this.value = value;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveString(key);
		ps.saveByte(type);
		ps.saveInt(value.length);
		ps.saveArray(value);
	}

	public void load(PacketInputStream ps) throws IOException {
		key = ps.loadString();
		type = ps.loadByte();
		int valueCount = ps.loadInt();
		value = new byte[valueCount];
		ps.loadByteArray(value);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Param :");
		result.append((new StringBuilder()).append(" key[").append(key).append("]").toString());
		result.append((new StringBuilder()).append(" type[").append(type).append("]").toString());
		result.append((new StringBuilder()).append(" value[").append(ArrayUtils.toString(value, 20)).append("]").toString());
		return result.toString();
	}
}