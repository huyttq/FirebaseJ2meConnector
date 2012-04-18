// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public final class TournamentUpdateListPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 156;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public List updates;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public TournamentUpdateListPacket() {
		// Nothing here
	}

	public TournamentUpdateListPacket(List updates) {
		this.updates = updates;
	}

	public void save(PacketOutputStream ps) throws IOException {
		if (updates == null) {
			ps.saveInt(0);
		} else {
			ps.saveInt(updates.size());
			for (int i = 0; i != updates.size(); ++i) {
				((TournamentUpdatePacket) updates.get(i)).save(ps);
			}
		}
	}

	public void load(PacketInputStream ps) throws IOException {
		int updatesCount = ps.loadInt();
		updates = new ArrayList(updatesCount);
		for (int i = 0; i != updatesCount; ++i) {
			TournamentUpdatePacket _tmp = new TournamentUpdatePacket();
			_tmp.load(ps);
			updates.add(_tmp);
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("TournamentUpdateListPacket :");
		result.append(" updates[" + updates + "]");
		return result.toString();
	}
}
