// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class NotifyLeavePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 61;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int tableid;
	public int pid;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public NotifyLeavePacket() {
		// Nothing here
	}

	public NotifyLeavePacket(int tableid, int pid) {
		this.tableid = tableid;
		this.pid = pid;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(tableid);
		ps.saveInt(pid);
	}

	public void load(PacketInputStream ps) throws IOException {
		tableid = ps.loadInt();
		pid = ps.loadInt();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("NotifyLeavePacket :");
		result.append(" tableid[" + tableid + "]");
		result.append(" pid[" + pid + "]");
		return result.toString();
	}
}
