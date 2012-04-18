// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class VersionPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 0;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int game;
	public int operatorid;
	public int protocol;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public VersionPacket() {
		// Nothing here
	}

	public VersionPacket(int game, int operatorid, int protocol) {
		this.game = game;
		this.operatorid = operatorid;
		this.protocol = protocol;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(game);
		ps.saveInt(operatorid);
		ps.saveInt(protocol);
	}

	public void load(PacketInputStream ps) throws IOException {
		game = ps.loadInt();
		operatorid = ps.loadInt();
		protocol = ps.loadInt();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("VersionPacket :");
		result.append(" game[" + game + "]");
		result.append(" operatorid[" + operatorid + "]");
		result.append(" protocol[" + protocol + "]");
		return result.toString();
	}
}
