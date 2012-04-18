// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class PlayerQueryRequestPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 16;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int pid;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public PlayerQueryRequestPacket() {
		// Nothing here
	}

	public PlayerQueryRequestPacket(int pid) {
		this.pid = pid;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(pid);
	}

	public void load(PacketInputStream ps) throws IOException {
		pid = ps.loadInt();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("PlayerQueryRequestPacket :");
		result.append(" pid[" + pid + "]");
		return result.toString();
	}
}
