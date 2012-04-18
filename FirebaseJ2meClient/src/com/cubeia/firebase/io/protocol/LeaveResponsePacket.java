// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class LeaveResponsePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 37;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int tableid;
	public Enums.ResponseStatus status = Enums.makeResponseStatus(0);
	public int code;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public LeaveResponsePacket() {
		// Nothing here
	}

	public LeaveResponsePacket(int tableid, Enums.ResponseStatus status, int code) {
		this.tableid = tableid;
		this.status = status;
		this.code = code;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(tableid);
		ps.saveUnsignedByte(status.ordinal());
		ps.saveInt(code);
	}

	public void load(PacketInputStream ps) throws IOException {
		tableid = ps.loadInt();
		status = Enums.makeResponseStatus(ps.loadUnsignedByte());
		code = ps.loadInt();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("LeaveResponsePacket :");
		result.append(" tableid[" + tableid + "]");
		result.append(" status[" + status + "]");
		result.append(" code[" + code + "]");
		return result.toString();
	}
}
