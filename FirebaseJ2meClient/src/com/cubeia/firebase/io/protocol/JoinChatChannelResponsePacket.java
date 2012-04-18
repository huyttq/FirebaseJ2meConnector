// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class JoinChatChannelResponsePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 121;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int channelid;
	public Enums.ResponseStatus status = Enums.makeResponseStatus(0);

	/**
	 * Default
	 * constructor.
	 *
	 */
	public JoinChatChannelResponsePacket() {
		// Nothing here
	}

	public JoinChatChannelResponsePacket(int channelid, Enums.ResponseStatus status) {
		this.channelid = channelid;
		this.status = status;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(channelid);
		ps.saveUnsignedByte(status.ordinal());
	}

	public void load(PacketInputStream ps) throws IOException {
		channelid = ps.loadInt();
		status = Enums.makeResponseStatus(ps.loadUnsignedByte());
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("JoinChatChannelResponsePacket :");
		result.append(" channelid[" + channelid + "]");
		result.append(" status[" + status + "]");
		return result.toString();
	}
}
