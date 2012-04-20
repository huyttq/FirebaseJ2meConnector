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

public final class FilteredJoinTableRequestPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 170;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int seq;
	public int gameid;
	public String address;
	public List params;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public FilteredJoinTableRequestPacket() {
		// Nothing here
	}

	public FilteredJoinTableRequestPacket(int seq, int gameid, String address, List params) {
		this.seq = seq;
		this.gameid = gameid;
		this.address = address;
		this.params = params;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(seq);
		ps.saveInt(gameid);
		ps.saveString(address);
		if (params == null) {
			ps.saveInt(0);
		} else {
			ps.saveInt(params.size());
			for (int i = 0; i != params.size(); ++i) {
				((ParamFilter) params.get(i)).save(ps);
			}
		}
	}

	public void load(PacketInputStream ps) throws IOException {
		seq = ps.loadInt();
		gameid = ps.loadInt();
		address = ps.loadString();
		int paramsCount = ps.loadInt();
		params = new ArrayList(paramsCount);
		for (int i = 0; i != paramsCount; ++i) {
			ParamFilter _tmp = new ParamFilter();
			_tmp.load(ps);
			params.add(_tmp);
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("FilteredJoinTableRequestPacket :");
		result.append(" seq[" + seq + "]");
		result.append(" gameid[" + gameid + "]");
		result.append(" address[" + address + "]");
		result.append(" params[" + params + "]");
		return result.toString();
	}
}
