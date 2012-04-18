// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class NotifySeatedPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 62;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int tableid;
	public byte seat;
	public int mttid;
	public TableSnapshotPacket snapshot;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public NotifySeatedPacket() {
		// Nothing here
	}

	public NotifySeatedPacket(int tableid, byte seat, int mttid, TableSnapshotPacket snapshot) {
		this.tableid = tableid;
		this.seat = seat;
		this.mttid = mttid;
		this.snapshot = snapshot;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(tableid);
		ps.saveByte(seat);
		ps.saveInt(mttid);
		snapshot.save(ps);
	}

	public void load(PacketInputStream ps) throws IOException {
		tableid = ps.loadInt();
		seat = ps.loadByte();
		mttid = ps.loadInt();
		snapshot = new TableSnapshotPacket();
		snapshot.load(ps);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("NotifySeatedPacket :");
		result.append(" tableid[" + tableid + "]");
		result.append(" seat[" + seat + "]");
		result.append(" mttid[" + mttid + "]");
		result.append(" snapshot[" + snapshot + "]");
		return result.toString();
	}
}
