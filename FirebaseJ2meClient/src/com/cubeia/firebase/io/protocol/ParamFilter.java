// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class ParamFilter implements ProtocolObject, Visitable {

	public int classId() {
		return 6;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public Param param;
	public byte op;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public ParamFilter() {
		// Nothing here
	}

	public ParamFilter(Param param, byte op) {
		this.param = param;
		this.op = op;
	}

	public void save(PacketOutputStream ps) throws IOException {
		param.save(ps);
		ps.saveByte(op);
	}

	public void load(PacketInputStream ps) throws IOException {
		param = new Param();
		param.load(ps);
		op = ps.loadByte();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("ParamFilter :");
		result.append(" param[" + param + "]");
		result.append(" op[" + op + "]");
		return result.toString();
	}
}
