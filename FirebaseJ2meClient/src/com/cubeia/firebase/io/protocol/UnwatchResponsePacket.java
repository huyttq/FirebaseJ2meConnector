// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class UnwatchResponsePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 35;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int tableid;
	public Enums.ResponseStatus status = Enums.makeResponseStatus(0);

	/**
	 * Default
	 * constructor.
	 *
	 */
	public UnwatchResponsePacket() {
		// Nothing here
	}

	public UnwatchResponsePacket(int tableid, Enums.ResponseStatus status) {
		this.tableid = tableid;
		this.status = status;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(tableid);
		ps.saveUnsignedByte(status.ordinal());
	}

	public void load(PacketInputStream ps) throws IOException {
		tableid = ps.loadInt();
		status = Enums.makeResponseStatus(ps.loadUnsignedByte());
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("UnwatchResponsePacket :");
		result.append(" tableid[" + tableid + "]");
		result.append(" status[" + status + "]");
		return result.toString();
	}
}
