// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class FilteredJoinTableAvailablePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 174;
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

	/**
	 * Default
	 * constructor.
	 *
	 */
	public FilteredJoinTableAvailablePacket() {
		// Nothing here
	}

	public FilteredJoinTableAvailablePacket(int seq, int tableid, byte seat) {
		this.seq = seq;
		this.tableid = tableid;
		this.seat = seat;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(seq);
		ps.saveInt(tableid);
		ps.saveByte(seat);
	}

	public void load(PacketInputStream ps) throws IOException {
		seq = ps.loadInt();
		tableid = ps.loadInt();
		seat = ps.loadByte();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("FilteredJoinTableAvailablePacket :");
		result.append(" seq[" + seq + "]");
		result.append(" tableid[" + tableid + "]");
		result.append(" seat[" + seat + "]");
		return result.toString();
	}
}
