// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class MttRegisterResponsePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 206;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int mttid;
	public Enums.TournamentRegisterResponseStatus status = Enums.makeTournamentRegisterResponseStatus(0);

	/**
	 * Default
	 * constructor.
	 *
	 */
	public MttRegisterResponsePacket() {
		// Nothing here
	}

	public MttRegisterResponsePacket(int mttid, Enums.TournamentRegisterResponseStatus status) {
		this.mttid = mttid;
		this.status = status;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(mttid);
		ps.saveUnsignedByte(status.ordinal());
	}

	public void load(PacketInputStream ps) throws IOException {
		mttid = ps.loadInt();
		status = Enums.makeTournamentRegisterResponseStatus(ps.loadUnsignedByte());
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("MttRegisterResponsePacket :");
		result.append(" mttid[" + mttid + "]");
		result.append(" status[" + status + "]");
		return result.toString();
	}
}
