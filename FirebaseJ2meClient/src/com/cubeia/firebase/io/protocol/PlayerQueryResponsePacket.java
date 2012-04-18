// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import com.cubeia.firebase.styx.util.ArrayUtils;
import j2me.lang.StringBuilder;

import java.io.IOException;

public final class PlayerQueryResponsePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 17;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int pid;
	public String nick;
	public Enums.ResponseStatus status = Enums.makeResponseStatus(0);
	public byte[] data = new byte[0];

	/**
	 * Default
	 * constructor.
	 *
	 */
	public PlayerQueryResponsePacket() {
		// Nothing here
	}

	public PlayerQueryResponsePacket(int pid, String nick, Enums.ResponseStatus status, byte[] data) {
		this.pid = pid;
		this.nick = nick;
		this.status = status;
		this.data = data;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(pid);
		ps.saveString(nick);
		ps.saveUnsignedByte(status.ordinal());
		ps.saveInt(data.length);
		ps.saveArray(data);
	}

	public void load(PacketInputStream ps) throws IOException {
		pid = ps.loadInt();
		nick = ps.loadString();
		status = Enums.makeResponseStatus(ps.loadUnsignedByte());
		int dataCount = ps.loadInt();
		data = new byte[dataCount];
		ps.loadByteArray(data);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("PlayerQueryResponsePacket :");
		result.append(" pid[" + pid + "]");
		result.append(" nick[" + nick + "]");
		result.append(" status[" + status + "]");
		result.append(" data[" + ArrayUtils.toString(data, 20) + "]");
		return result.toString();
	}
}
