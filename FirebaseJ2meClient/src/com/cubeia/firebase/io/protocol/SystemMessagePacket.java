// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class SystemMessagePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 4;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int type;
	public int level;
	public String message;
	public int[] pids = new int[0];

	/**
	 * Default
	 * constructor.
	 *
	 */
	public SystemMessagePacket() {
		// Nothing here
	}

	public SystemMessagePacket(int type, int level, String message, int[] pids) {
		this.type = type;
		this.level = level;
		this.message = message;
		this.pids = pids;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(type);
		ps.saveInt(level);
		ps.saveString(message);
		ps.saveInt(pids.length);
		ps.saveArray(pids);
	}

	public void load(PacketInputStream ps) throws IOException {
		type = ps.loadInt();
		level = ps.loadInt();
		message = ps.loadString();
		int pidsCount = ps.loadInt();
		pids = new int[pidsCount];
		ps.loadIntArray(pids);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("SystemMessagePacket :");
		result.append(" type[" + type + "]");
		result.append(" level[" + level + "]");
		result.append(" message[" + message + "]");
		result.append(" pids[" + pids + "]");
		return result.toString();
	}
}
