// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class NotifyChannelChatPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 123;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int pid;
	public int channelid;
	public int targetid;
	public String nick;
	public String message;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public NotifyChannelChatPacket() {
		// Nothing here
	}

	public NotifyChannelChatPacket(int pid, int channelid, int targetid, String nick, String message) {
		this.pid = pid;
		this.channelid = channelid;
		this.targetid = targetid;
		this.nick = nick;
		this.message = message;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(pid);
		ps.saveInt(channelid);
		ps.saveInt(targetid);
		ps.saveString(nick);
		ps.saveString(message);
	}

	public void load(PacketInputStream ps) throws IOException {
		pid = ps.loadInt();
		channelid = ps.loadInt();
		targetid = ps.loadInt();
		nick = ps.loadString();
		message = ps.loadString();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("NotifyChannelChatPacket :");
		result.append(" pid[" + pid + "]");
		result.append(" channelid[" + channelid + "]");
		result.append(" targetid[" + targetid + "]");
		result.append(" nick[" + nick + "]");
		result.append(" message[" + message + "]");
		return result.toString();
	}
}
