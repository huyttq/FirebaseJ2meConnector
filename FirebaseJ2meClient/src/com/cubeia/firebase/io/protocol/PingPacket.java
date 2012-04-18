// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class PingPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 7;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int id;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public PingPacket() {
		// Nothing here
	}

	public PingPacket(int id) {
		this.id = id;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(id);
	}

	public void load(PacketInputStream ps) throws IOException {
		id = ps.loadInt();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("PingPacket :");
		result.append(" id[" + id + "]");
		return result.toString();
	}
}
