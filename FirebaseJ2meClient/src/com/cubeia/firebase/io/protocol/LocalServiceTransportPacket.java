// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import com.cubeia.firebase.styx.util.ArrayUtils;
import j2me.lang.StringBuilder;

import java.io.IOException;

public final class LocalServiceTransportPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 103;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int seq;
	public byte[] servicedata = new byte[0];

	/**
	 * Default
	 * constructor.
	 *
	 */
	public LocalServiceTransportPacket() {
		// Nothing here
	}

	public LocalServiceTransportPacket(int seq, byte[] servicedata) {
		this.seq = seq;
		this.servicedata = servicedata;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(seq);
		ps.saveInt(servicedata.length);
		ps.saveArray(servicedata);
	}

	public void load(PacketInputStream ps) throws IOException {
		seq = ps.loadInt();
		int servicedataCount = ps.loadInt();
		servicedata = new byte[servicedataCount];
		ps.loadByteArray(servicedata);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("LocalServiceTransportPacket :");
		result.append(" seq[" + seq + "]");
		result.append(" servicedata[" + ArrayUtils.toString(servicedata, 20) + "]");
		return result.toString();
	}
}
