// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class NotifyRegisteredPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 211;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int[] tournaments = new int[0];

	/**
	 * Default
	 * constructor.
	 *
	 */
	public NotifyRegisteredPacket() {
		// Nothing here
	}

	public NotifyRegisteredPacket(int[] tournaments) {
		this.tournaments = tournaments;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(tournaments.length);
		ps.saveArray(tournaments);
	}

	public void load(PacketInputStream ps) throws IOException {
		int tournamentsCount = ps.loadInt();
		tournaments = new int[tournamentsCount];
		ps.loadIntArray(tournaments);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("NotifyRegisteredPacket :");
		result.append(" tournaments[" + tournaments + "]");
		return result.toString();
	}
}
