// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;

import j2me.util.List;
import j2me.util.ArrayList;
import java.io.IOException;

public final class ProbePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 201;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int id;
	public int tableid;
	public List stamps;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public ProbePacket() {
		// Nothing here
	}

	public ProbePacket(int id, int tableid, List stamps) {
		this.id = id;
		this.tableid = tableid;
		this.stamps = stamps;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(id);
		ps.saveInt(tableid);
		if (stamps == null) {
			ps.saveInt(0);
		} else {
			ps.saveInt(stamps.size());
			for (int i = 0; i != stamps.size(); ++i) {
				((ProbeStamp) stamps.get(i)).save(ps);
			}
		}
	}

	public void load(PacketInputStream ps) throws IOException {
		id = ps.loadInt();
		tableid = ps.loadInt();
		int stampsCount = ps.loadInt();
		stamps = new ArrayList(stampsCount);
		for (int i = 0; i != stampsCount; ++i) {
			ProbeStamp _tmp = new ProbeStamp();
			_tmp.load(ps);
			stamps.add(_tmp);
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("ProbePacket :");
		result.append(" id[" + id + "]");
		result.append(" tableid[" + tableid + "]");
		result.append(" stamps[" + stamps + "]");
		return result.toString();
	}
}
