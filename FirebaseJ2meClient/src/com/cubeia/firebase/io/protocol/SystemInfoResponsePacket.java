// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;

import j2me.util.List;
import j2me.util.ArrayList;
import java.io.IOException;

public final class SystemInfoResponsePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 19;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int players;
	public List params;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public SystemInfoResponsePacket() {
		// Nothing here
	}

	public SystemInfoResponsePacket(int players, List params) {
		this.players = players;
		this.params = params;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(players);
		if (params == null) {
			ps.saveInt(0);
		} else {
			ps.saveInt(params.size());
			for (int i = 0; i != params.size(); ++i) {
				((Param) params.get(i)).save(ps);
			}
		}
	}

	public void load(PacketInputStream ps) throws IOException {
		players = ps.loadInt();
		int paramsCount = ps.loadInt();
		params = new ArrayList(paramsCount);
		for (int i = 0; i != paramsCount; ++i) {
			Param _tmp = new Param();
			_tmp.load(ps);
			params.add(_tmp);
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("SystemInfoResponsePacket :");
		result.append(" players[" + players + "]");
		result.append(" params[" + params + "]");
		return result.toString();
	}
}
