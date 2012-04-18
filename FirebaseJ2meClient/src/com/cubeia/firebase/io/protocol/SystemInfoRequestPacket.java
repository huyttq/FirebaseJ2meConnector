// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class SystemInfoRequestPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 18;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}

	/**
	 * Default
	 * constructor.
	 *
	 */
	public SystemInfoRequestPacket() {
		// Nothing here
	}

	public void save(PacketOutputStream ps) throws IOException {
	}

	public void load(PacketInputStream ps) throws IOException {
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("SystemInfoRequestPacket :");
		return result.toString();
	}
}
