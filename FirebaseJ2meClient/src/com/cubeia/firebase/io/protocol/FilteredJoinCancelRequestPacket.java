// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;

import java.io.IOException;

public final class FilteredJoinCancelRequestPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 172;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int seq;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public FilteredJoinCancelRequestPacket() {
		// Nothing here
	}

	public FilteredJoinCancelRequestPacket(int seq) {
		this.seq = seq;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(seq);
	}

	public void load(PacketInputStream ps) throws IOException {
		seq = ps.loadInt();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("FilteredJoinCancelRequestPacket :");
		result.append(" seq[" + seq + "]");
		return result.toString();
	}
}
