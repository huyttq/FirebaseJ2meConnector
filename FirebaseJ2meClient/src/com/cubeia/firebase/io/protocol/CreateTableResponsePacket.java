// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;

import java.io.IOException;

public final class CreateTableResponsePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 41;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int seq;
	public int tableid;
	public byte seat;
	public Enums.ResponseStatus status = Enums.makeResponseStatus(0);
	public int code;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public CreateTableResponsePacket() {
		// Nothing here
	}

	public CreateTableResponsePacket(int seq, int tableid, byte seat, Enums.ResponseStatus status, int code) {
		this.seq = seq;
		this.tableid = tableid;
		this.seat = seat;
		this.status = status;
		this.code = code;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(seq);
		ps.saveInt(tableid);
		ps.saveByte(seat);
		ps.saveUnsignedByte(status.ordinal());
		ps.saveInt(code);
	}

	public void load(PacketInputStream ps) throws IOException {
		seq = ps.loadInt();
		tableid = ps.loadInt();
		seat = ps.loadByte();
		status = Enums.makeResponseStatus(ps.loadUnsignedByte());
		code = ps.loadInt();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("CreateTableResponsePacket :");
		result.append(" seq[" + seq + "]");
		result.append(" tableid[" + tableid + "]");
		result.append(" seat[" + seat + "]");
		result.append(" status[" + status + "]");
		result.append(" code[" + code + "]");
		return result.toString();
	}
}
