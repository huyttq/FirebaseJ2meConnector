// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class WatchResponsePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 33;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int tableid;
	public Enums.WatchResponseStatus status = Enums.makeWatchResponseStatus(0);

	/**
	 * Default
	 * constructor.
	 *
	 */
	public WatchResponsePacket() {
		// Nothing here
	}

	public WatchResponsePacket(int tableid, Enums.WatchResponseStatus status) {
		this.tableid = tableid;
		this.status = status;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(tableid);
		ps.saveUnsignedByte(status.ordinal());
	}

	public void load(PacketInputStream ps) throws IOException {
		tableid = ps.loadInt();
		status = Enums.makeWatchResponseStatus(ps.loadUnsignedByte());
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("WatchResponsePacket :");
		result.append(" tableid[" + tableid + "]");
		result.append(" status[" + status + "]");
		return result.toString();
	}
}
