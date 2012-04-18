// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public final class TableUpdatePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 144;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int tableid;
	public short seated;
	public List params;
	public String[] removedParams = new String[0];

	/**
	 * Default
	 * constructor.
	 *
	 */
	public TableUpdatePacket() {
		// Nothing here
	}

	public TableUpdatePacket(int tableid, short seated, List params, String[] removedParams) {
		this.tableid = tableid;
		this.seated = seated;
		this.params = params;
		this.removedParams = removedParams;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(tableid);
		ps.saveShort(seated);
		if (params == null) {
			ps.saveInt(0);
		} else {
			ps.saveInt(params.size());
			for (int i = 0; i != params.size(); ++i) {
				((Param) params.get(i)).save(ps);
			}
		}
		ps.saveInt(removedParams.length);
		ps.saveArray(removedParams);
	}

	public void load(PacketInputStream ps) throws IOException {
		tableid = ps.loadInt();
		seated = ps.loadShort();
		int paramsCount = ps.loadInt();
		params = new ArrayList(paramsCount);
		for (int i = 0; i != paramsCount; ++i) {
			Param _tmp = new Param();
			_tmp.load(ps);
			params.add(_tmp);
		}
		int removedParamsCount = ps.loadInt();
		removedParams = new String[removedParamsCount];
		ps.loadStringArray(removedParams);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("TableUpdatePacket :");
		result.append(" tableid[" + tableid + "]");
		result.append(" seated[" + seated + "]");
		result.append(" params[" + params + "]");
		result.append(" removed_params[" + removedParams + "]");
		return result.toString();
	}
}
