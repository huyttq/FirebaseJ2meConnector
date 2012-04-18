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

public final class GameTransportPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 100;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int tableid;
	public int pid;
	public byte[] gamedata = new byte[0];
	public List attributes;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public GameTransportPacket() {
		// Nothing here
	}

	public GameTransportPacket(int tableid, int pid, byte[] gamedata, List attributes) {
		this.tableid = tableid;
		this.pid = pid;
		this.gamedata = gamedata;
		this.attributes = attributes;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(tableid);
		ps.saveInt(pid);
		ps.saveInt(gamedata.length);
		ps.saveArray(gamedata);
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
		tableid = ps.loadInt();
		pid = ps.loadInt();
		int gamedataCount = ps.loadInt();
		gamedata = new byte[gamedataCount];
		ps.loadByteArray(gamedata);
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
		result.append("GameTransportPacket :");
		result.append(" tableid[" + tableid + "]");
		result.append(" pid[" + pid + "]");
		result.append(" gamedata[" + ArrayUtils.toString(gamedata, 20) + "]");
		result.append(" attributes[" + attributes + "]");
		return result.toString();
	}
}
