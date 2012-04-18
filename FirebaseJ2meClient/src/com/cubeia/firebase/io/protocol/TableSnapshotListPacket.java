// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import com.cubeia.firebase.styx.util.ArrayUtils;
import j2me.lang.StringBuilder;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public final class TableSnapshotListPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 153;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public List snapshots;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public TableSnapshotListPacket() {
		// Nothing here
	}

	public TableSnapshotListPacket(List snapshots) {
		this.snapshots = snapshots;
	}

	public void save(PacketOutputStream ps) throws IOException {
		if (snapshots == null) {
			ps.saveInt(0);
		} else {
			ps.saveInt(snapshots.size());
			for (int i = 0; i != snapshots.size(); ++i) {
				((TableSnapshotPacket) snapshots.get(i)).save(ps);
			}
		}
	}

	public void load(PacketInputStream ps) throws IOException {
		int snapshotsCount = ps.loadInt();
		snapshots = new ArrayList(snapshotsCount);
		for (int i = 0; i != snapshotsCount; ++i) {
			TableSnapshotPacket _tmp = new TableSnapshotPacket();
			_tmp.load(ps);
			snapshots.add(_tmp);
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("TableSnapshotListPacket :");
		result.append(" snapshots[" + snapshots + "]");
		return result.toString();
	}
}
