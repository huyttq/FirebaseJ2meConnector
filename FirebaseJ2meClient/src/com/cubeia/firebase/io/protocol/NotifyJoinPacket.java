// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class NotifyJoinPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 60;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int tableid;
	public int pid;
	public String nick;
	public byte seat;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public NotifyJoinPacket() {
		// Nothing here
	}

	public NotifyJoinPacket(int tableid, int pid, String nick, byte seat) {
		this.tableid = tableid;
		this.pid = pid;
		this.nick = nick;
		this.seat = seat;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(tableid);
		ps.saveInt(pid);
		ps.saveString(nick);
		ps.saveByte(seat);
	}

	public void load(PacketInputStream ps) throws IOException {
		tableid = ps.loadInt();
		pid = ps.loadInt();
		nick = ps.loadString();
		seat = ps.loadByte();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("NotifyJoinPacket :");
		result.append(" tableid[" + tableid + "]");
		result.append(" pid[" + pid + "]");
		result.append(" nick[" + nick + "]");
		result.append(" seat[" + seat + "]");
		return result.toString();
	}
}
