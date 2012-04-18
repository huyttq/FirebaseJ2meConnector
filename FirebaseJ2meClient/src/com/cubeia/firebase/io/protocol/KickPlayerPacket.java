// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class KickPlayerPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 64;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int tableid;
	public short reasonCode;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public KickPlayerPacket() {
		// Nothing here
	}

	public KickPlayerPacket(int tableid, short reasonCode) {
		this.tableid = tableid;
		this.reasonCode = reasonCode;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(tableid);
		ps.saveShort(reasonCode);
	}

	public void load(PacketInputStream ps) throws IOException {
		tableid = ps.loadInt();
		reasonCode = ps.loadShort();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("KickPlayerPacket :");
		result.append(" tableid[" + tableid + "]");
		result.append(" reasonCode[" + reasonCode + "]");
		return result.toString();
	}
}
