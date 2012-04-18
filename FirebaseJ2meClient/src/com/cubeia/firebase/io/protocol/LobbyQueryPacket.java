// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class LobbyQueryPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 142;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int gameid;
	public String address;
	public Enums.LobbyType type = Enums.makeLobbyType(0);

	/**
	 * Default
	 * constructor.
	 *
	 */
	public LobbyQueryPacket() {
		// Nothing here
	}

	public LobbyQueryPacket(int gameid, String address, Enums.LobbyType type) {
		this.gameid = gameid;
		this.address = address;
		this.type = type;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(gameid);
		ps.saveString(address);
		ps.saveUnsignedByte(type.ordinal());
	}

	public void load(PacketInputStream ps) throws IOException {
		gameid = ps.loadInt();
		address = ps.loadString();
		type = Enums.makeLobbyType(ps.loadUnsignedByte());
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("LobbyQueryPacket :");
		result.append(" gameid[" + gameid + "]");
		result.append(" address[" + address + "]");
		result.append(" type[" + type + "]");
		return result.toString();
	}
}
