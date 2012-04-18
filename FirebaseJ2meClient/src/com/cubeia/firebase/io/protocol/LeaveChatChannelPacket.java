// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class LeaveChatChannelPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 122;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int channelid;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public LeaveChatChannelPacket() {
		// Nothing here
	}

	public LeaveChatChannelPacket(int channelid) {
		this.channelid = channelid;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(channelid);
	}

	public void load(PacketInputStream ps) throws IOException {
		channelid = ps.loadInt();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("LeaveChatChannelPacket :");
		result.append(" channelid[" + channelid + "]");
		return result.toString();
	}
}
