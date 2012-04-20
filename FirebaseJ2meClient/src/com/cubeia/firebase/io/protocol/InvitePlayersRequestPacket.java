// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;

import java.io.IOException;

public final class InvitePlayersRequestPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 42;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int tableid;
	public int[] invitees = new int[0];

	/**
	 * Default
	 * constructor.
	 *
	 */
	public InvitePlayersRequestPacket() {
		// Nothing here
	}

	public InvitePlayersRequestPacket(int tableid, int[] invitees) {
		this.tableid = tableid;
		this.invitees = invitees;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(tableid);
		ps.saveInt(invitees.length);
		ps.saveArray(invitees);
	}

	public void load(PacketInputStream ps) throws IOException {
		tableid = ps.loadInt();
		int inviteesCount = ps.loadInt();
		invitees = new int[inviteesCount];
		ps.loadIntArray(invitees);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("InvitePlayersRequestPacket :");
		result.append(" tableid[" + tableid + "]");
		result.append(" invitees[" + invitees + "]");
		return result.toString();
	}
}
