// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;

import java.io.IOException;

public final class FilteredJoinTableResponsePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 171;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int seq;
	public int gameid;
	public String address;
	public Enums.FilteredJoinResponseStatus status = Enums.makeFilteredJoinResponseStatus(0);

	/**
	 * Default
	 * constructor.
	 *
	 */
	public FilteredJoinTableResponsePacket() {
		// Nothing here
	}

	public FilteredJoinTableResponsePacket(int seq, int gameid, String address, Enums.FilteredJoinResponseStatus status) {
		this.seq = seq;
		this.gameid = gameid;
		this.address = address;
		this.status = status;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(seq);
		ps.saveInt(gameid);
		ps.saveString(address);
		ps.saveUnsignedByte(status.ordinal());
	}

	public void load(PacketInputStream ps) throws IOException {
		seq = ps.loadInt();
		gameid = ps.loadInt();
		address = ps.loadString();
		status = Enums.makeFilteredJoinResponseStatus(ps.loadUnsignedByte());
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("FilteredJoinTableResponsePacket :");
		result.append(" seq[" + seq + "]");
		result.append(" gameid[" + gameid + "]");
		result.append(" address[" + address + "]");
		result.append(" status[" + status + "]");
		return result.toString();
	}
}
