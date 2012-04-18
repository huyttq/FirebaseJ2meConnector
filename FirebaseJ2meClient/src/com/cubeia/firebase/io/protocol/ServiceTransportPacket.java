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

public final class ServiceTransportPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 101;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int pid;
	public int seq;
	public String service;
	public byte idtype;
	public byte[] servicedata = new byte[0];
	public List attributes;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public ServiceTransportPacket() {
		// Nothing here
	}

	public ServiceTransportPacket(int pid, int seq, String service, byte idtype, byte[] servicedata, List attributes) {
		this.pid = pid;
		this.seq = seq;
		this.service = service;
		this.idtype = idtype;
		this.servicedata = servicedata;
		this.attributes = attributes;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(pid);
		ps.saveInt(seq);
		ps.saveString(service);
		ps.saveByte(idtype);
		ps.saveInt(servicedata.length);
		ps.saveArray(servicedata);
		if (attributes == null) {
			ps.saveInt(0);
		} else {
			ps.saveInt(attributes.size());
			for (int i = 0; i != attributes.size(); ++i) {
				((Attribute) attributes.get(i)).save(ps);
			}
		}
	}

	public void load(PacketInputStream ps) throws IOException {
		pid = ps.loadInt();
		seq = ps.loadInt();
		service = ps.loadString();
		idtype = ps.loadByte();
		int servicedataCount = ps.loadInt();
		servicedata = new byte[servicedataCount];
		ps.loadByteArray(servicedata);
		int attributesCount = ps.loadInt();
		attributes = new ArrayList(attributesCount);
		for (int i = 0; i != attributesCount; ++i) {
			Attribute _tmp = new Attribute();
			_tmp.load(ps);
			attributes.add(_tmp);
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("ServiceTransportPacket :");
		result.append(" pid[" + pid + "]");
		result.append(" seq[" + seq + "]");
		result.append(" service[" + service + "]");
		result.append(" idtype[" + idtype + "]");
		result.append(" servicedata[" + ArrayUtils.toString(servicedata, 20) + "]");
		result.append(" attributes[" + attributes + "]");
		return result.toString();
	}
}
