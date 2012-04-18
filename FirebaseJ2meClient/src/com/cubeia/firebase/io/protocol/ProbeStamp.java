// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class ProbeStamp implements ProtocolObject, Visitable {

	public int classId() {
		return 200;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public String clazz;
	public long timestamp;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public ProbeStamp() {
		// Nothing here
	}

	public ProbeStamp(String clazz, long timestamp) {
		this.clazz = clazz;
		this.timestamp = timestamp;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveString(clazz);
		ps.saveLong(timestamp);
	}

	public void load(PacketInputStream ps) throws IOException {
		clazz = ps.loadString();
		timestamp = ps.loadLong();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("ProbeStamp :");
		result.append(" clazz[" + clazz + "]");
		result.append(" timestamp[" + timestamp + "]");
		return result.toString();
	}
}
