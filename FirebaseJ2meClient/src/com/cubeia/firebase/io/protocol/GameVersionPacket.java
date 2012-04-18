// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class GameVersionPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 1;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int game;
	public int operatorid;
	public String version;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public GameVersionPacket() {
		// Nothing here
	}

	public GameVersionPacket(int game, int operatorid, String version) {
		this.game = game;
		this.operatorid = operatorid;
		this.version = version;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(game);
		ps.saveInt(operatorid);
		ps.saveString(version);
	}

	public void load(PacketInputStream ps) throws IOException {
		game = ps.loadInt();
		operatorid = ps.loadInt();
		version = ps.loadString();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("GameVersionPacket :");
		result.append(" game[" + game + "]");
		result.append(" operatorid[" + operatorid + "]");
		result.append(" version[" + version + "]");
		return result.toString();
	}
}
