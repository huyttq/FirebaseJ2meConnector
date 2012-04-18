// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class NotifyInvitedPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 43;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int inviter;
	public String screenname;
	public int tableid;
	public byte seat;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public NotifyInvitedPacket() {
		// Nothing here
	}

	public NotifyInvitedPacket(int inviter, String screenname, int tableid, byte seat) {
		this.inviter = inviter;
		this.screenname = screenname;
		this.tableid = tableid;
		this.seat = seat;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(inviter);
		ps.saveString(screenname);
		ps.saveInt(tableid);
		ps.saveByte(seat);
	}

	public void load(PacketInputStream ps) throws IOException {
		inviter = ps.loadInt();
		screenname = ps.loadString();
		tableid = ps.loadInt();
		seat = ps.loadByte();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("NotifyInvitedPacket :");
		result.append(" inviter[" + inviter + "]");
		result.append(" screenname[" + screenname + "]");
		result.append(" tableid[" + tableid + "]");
		result.append(" seat[" + seat + "]");
		return result.toString();
	}
}
