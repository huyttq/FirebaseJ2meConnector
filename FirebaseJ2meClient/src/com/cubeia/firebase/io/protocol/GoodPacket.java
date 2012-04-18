// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class GoodPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 2;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public byte cmd;
	public int extra;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public GoodPacket() {
		// Nothing here
	}

	public GoodPacket(byte cmd, int extra) {
		this.cmd = cmd;
		this.extra = extra;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveByte(cmd);
		ps.saveInt(extra);
	}

	public void load(PacketInputStream ps) throws IOException {
		cmd = ps.loadByte();
		extra = ps.loadInt();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("GoodPacket :");
		result.append(" cmd[" + cmd + "]");
		result.append(" extra[" + extra + "]");
		return result.toString();
	}
}
