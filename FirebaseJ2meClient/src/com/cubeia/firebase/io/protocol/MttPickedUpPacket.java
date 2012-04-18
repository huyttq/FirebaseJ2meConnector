// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class MttPickedUpPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 210;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int mttid;
	public int tableid;
	public boolean keepWatching;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public MttPickedUpPacket() {
		// Nothing here
	}

	public MttPickedUpPacket(int mttid, int tableid, boolean keepWatching) {
		this.mttid = mttid;
		this.tableid = tableid;
		this.keepWatching = keepWatching;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(mttid);
		ps.saveInt(tableid);
		ps.saveBoolean(keepWatching);
	}

	public void load(PacketInputStream ps) throws IOException {
		mttid = ps.loadInt();
		tableid = ps.loadInt();
		keepWatching = ps.loadBoolean();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("MttPickedUpPacket :");
		result.append(" mttid[" + mttid + "]");
		result.append(" tableid[" + tableid + "]");
		result.append(" keep_watching[" + keepWatching + "]");
		return result.toString();
	}
}
