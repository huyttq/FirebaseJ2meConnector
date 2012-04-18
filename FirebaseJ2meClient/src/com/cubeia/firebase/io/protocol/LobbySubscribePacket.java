// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class LobbySubscribePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 145;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public Enums.LobbyType type = Enums.makeLobbyType(0);
	public int gameid;
	public String address;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public LobbySubscribePacket() {
		// Nothing here
	}

	public LobbySubscribePacket(Enums.LobbyType type, int gameid, String address) {
		this.type = type;
		this.gameid = gameid;
		this.address = address;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveUnsignedByte(type.ordinal());
		ps.saveInt(gameid);
		ps.saveString(address);
	}

	public void load(PacketInputStream ps) throws IOException {
		type = Enums.makeLobbyType(ps.loadUnsignedByte());
		gameid = ps.loadInt();
		address = ps.loadString();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("LobbySubscribePacket :");
		result.append(" type[" + type + "]");
		result.append(" gameid[" + gameid + "]");
		result.append(" address[" + address + "]");
		return result.toString();
	}
}
