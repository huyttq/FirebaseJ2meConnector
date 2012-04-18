// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class JoinResponsePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 31;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int tableid;
	public byte seat;
	public Enums.JoinResponseStatus status = Enums.makeJoinResponseStatus(0);
	public int code;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public JoinResponsePacket() {
		// Nothing here
	}

	public JoinResponsePacket(int tableid, byte seat, Enums.JoinResponseStatus status, int code) {
		this.tableid = tableid;
		this.seat = seat;
		this.status = status;
		this.code = code;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(tableid);
		ps.saveByte(seat);
		ps.saveUnsignedByte(status.ordinal());
		ps.saveInt(code);
	}

	public void load(PacketInputStream ps) throws IOException {
		tableid = ps.loadInt();
		seat = ps.loadByte();
		status = Enums.makeJoinResponseStatus(ps.loadUnsignedByte());
		code = ps.loadInt();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("JoinResponsePacket :");
		result.append(" tableid[" + tableid + "]");
		result.append(" seat[" + seat + "]");
		result.append(" status[" + status + "]");
		result.append(" code[" + code + "]");
		return result.toString();
	}
}
