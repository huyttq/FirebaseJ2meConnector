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

public final class TableSnapshotPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 143;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int tableid;
	public String address;
	public String name;
	public short capacity;
	public short seated;
	public List params;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public TableSnapshotPacket() {
		// Nothing here
	}

	public TableSnapshotPacket(int tableid, String address, String name, short capacity, short seated, List params) {
		this.tableid = tableid;
		this.address = address;
		this.name = name;
		this.capacity = capacity;
		this.seated = seated;
		this.params = params;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(tableid);
		ps.saveString(address);
		ps.saveString(name);
		ps.saveShort(capacity);
		ps.saveShort(seated);
		if (params == null) {
			ps.saveInt(0);
		} else {
			ps.saveInt(params.size());
			for (int i = 0; i != params.size(); ++i) {
				((Param) params.get(i)).save(ps);
			}
		}
	}

	public void load(PacketInputStream ps) throws IOException {
		tableid = ps.loadInt();
		address = ps.loadString();
		name = ps.loadString();
		capacity = ps.loadShort();
		seated = ps.loadShort();
		int paramsCount = ps.loadInt();
		params = new ArrayList(paramsCount);
		for (int i = 0; i != paramsCount; ++i) {
			Param _tmp = new Param();
			_tmp.load(ps);
			params.add(_tmp);
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("TableSnapshotPacket :");
		result.append(" tableid[" + tableid + "]");
		result.append(" address[" + address + "]");
		result.append(" name[" + name + "]");
		result.append(" capacity[" + capacity + "]");
		result.append(" seated[" + seated + "]");
		result.append(" params[" + params + "]");
		return result.toString();
	}
}
