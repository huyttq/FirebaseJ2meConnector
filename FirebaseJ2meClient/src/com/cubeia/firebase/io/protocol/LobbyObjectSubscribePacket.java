// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class LobbyObjectSubscribePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 151;
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
	public int objectid;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public LobbyObjectSubscribePacket() {
		// Nothing here
	}

	public LobbyObjectSubscribePacket(Enums.LobbyType type, int gameid, String address, int objectid) {
		this.type = type;
		this.gameid = gameid;
		this.address = address;
		this.objectid = objectid;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveUnsignedByte(type.ordinal());
		ps.saveInt(gameid);
		ps.saveString(address);
		ps.saveInt(objectid);
	}

	public void load(PacketInputStream ps) throws IOException {
		type = Enums.makeLobbyType(ps.loadUnsignedByte());
		gameid = ps.loadInt();
		address = ps.loadString();
		objectid = ps.loadInt();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("LobbyObjectSubscribePacket :");
		result.append(" type[" + type + "]");
		result.append(" gameid[" + gameid + "]");
		result.append(" address[" + address + "]");
		result.append(" objectid[" + objectid + "]");
		return result.toString();
	}
}
