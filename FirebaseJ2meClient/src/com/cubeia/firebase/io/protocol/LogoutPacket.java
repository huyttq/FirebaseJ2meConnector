// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class LogoutPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 12;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public boolean leaveTables;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public LogoutPacket() {
		// Nothing here
	}

	public LogoutPacket(boolean leaveTables) {
		this.leaveTables = leaveTables;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveBoolean(leaveTables);
	}

	public void load(PacketInputStream ps) throws IOException {
		leaveTables = ps.loadBoolean();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("LogoutPacket :");
		result.append(" leave_tables[" + leaveTables + "]");
		return result.toString();
	}
}
