// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class ForcedLogoutPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 14;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int code;
	public String message;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public ForcedLogoutPacket() {
		// Nothing here
	}

	public ForcedLogoutPacket(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(code);
		ps.saveString(message);
	}

	public void load(PacketInputStream ps) throws IOException {
		code = ps.loadInt();
		message = ps.loadString();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("ForcedLogoutPacket :");
		result.append(" code[" + code + "]");
		result.append(" message[" + message + "]");
		return result.toString();
	}
}
