// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class WatchRequestPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 32;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int tableid;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public WatchRequestPacket() {
		// Nothing here
	}

	public WatchRequestPacket(int tableid) {
		this.tableid = tableid;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(tableid);
	}

	public void load(PacketInputStream ps) throws IOException {
		tableid = ps.loadInt();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("WatchRequestPacket :");
		result.append(" tableid[" + tableid + "]");
		return result.toString();
	}
}
