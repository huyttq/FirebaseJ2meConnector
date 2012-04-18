// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class MttUnregisterRequestPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 207;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int mttid;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public MttUnregisterRequestPacket() {
		// Nothing here
	}

	public MttUnregisterRequestPacket(int mttid) {
		this.mttid = mttid;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(mttid);
	}

	public void load(PacketInputStream ps) throws IOException {
		mttid = ps.loadInt();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("MttUnregisterRequestPacket :");
		result.append(" mttid[" + mttid + "]");
		return result.toString();
	}
}
