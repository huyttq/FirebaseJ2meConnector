// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import com.cubeia.firebase.styx.util.ArrayUtils;
import j2me.lang.StringBuilder;

import j2me.util.List;
import j2me.util.ArrayList;
import java.io.IOException;

public final class MttTransportPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 104;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int mttid;
	public int pid;
	public byte[] mttdata = new byte[0];
	public List attributes;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public MttTransportPacket() {
		// Nothing here
	}

	public MttTransportPacket(int mttid, int pid, byte[] mttdata, List attributes) {
		this.mttid = mttid;
		this.pid = pid;
		this.mttdata = mttdata;
		this.attributes = attributes;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(mttid);
		ps.saveInt(pid);
		ps.saveInt(mttdata.length);
		ps.saveArray(mttdata);
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
		mttid = ps.loadInt();
		pid = ps.loadInt();
		int mttdataCount = ps.loadInt();
		mttdata = new byte[mttdataCount];
		ps.loadByteArray(mttdata);
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
		result.append("MttTransportPacket :");
		result.append(" mttid[" + mttid + "]");
		result.append(" pid[" + pid + "]");
		result.append(" mttdata[" + ArrayUtils.toString(mttdata, 20) + "]");
		result.append(" attributes[" + attributes + "]");
		return result.toString();
	}
}
