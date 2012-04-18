// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class TableChatPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 80;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int tableid;
	public int pid;
	public String message;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public TableChatPacket() {
		// Nothing here
	}

	public TableChatPacket(int tableid, int pid, String message) {
		this.tableid = tableid;
		this.pid = pid;
		this.message = message;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(tableid);
		ps.saveInt(pid);
		ps.saveString(message);
	}

	public void load(PacketInputStream ps) throws IOException {
		tableid = ps.loadInt();
		pid = ps.loadInt();
		message = ps.loadString();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("TableChatPacket :");
		result.append(" tableid[" + tableid + "]");
		result.append(" pid[" + pid + "]");
		result.append(" message[" + message + "]");
		return result.toString();
	}
}
