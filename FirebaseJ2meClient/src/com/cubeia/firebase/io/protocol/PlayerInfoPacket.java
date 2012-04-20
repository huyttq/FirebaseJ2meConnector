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

public final class PlayerInfoPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 13;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int pid;
	public String nick;
	public List details;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public PlayerInfoPacket() {
		// Nothing here
	}

	public PlayerInfoPacket(int pid, String nick, List details) {
		this.pid = pid;
		this.nick = nick;
		this.details = details;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(pid);
		ps.saveString(nick);
		if (details == null) {
			ps.saveInt(0);
		} else {
			ps.saveInt(details.size());
			for (int i = 0; i != details.size(); ++i) {
				((Param) details.get(i)).save(ps);
			}
		}
	}

	public void load(PacketInputStream ps) throws IOException {
		pid = ps.loadInt();
		nick = ps.loadString();
		int detailsCount = ps.loadInt();
		details = new ArrayList(detailsCount);
		for (int i = 0; i != detailsCount; ++i) {
			Param _tmp = new Param();
			_tmp.load(ps);
			details.add(_tmp);
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("PlayerInfoPacket :");
		result.append(" pid[" + pid + "]");
		result.append(" nick[" + nick + "]");
		result.append(" details[" + details + "]");
		return result.toString();
	}
}
