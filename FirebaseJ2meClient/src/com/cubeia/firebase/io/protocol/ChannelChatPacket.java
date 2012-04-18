// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:13 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ChannelChatPacket.java
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor
public final class ChannelChatPacket
				implements ProtocolObject, Visitable {

	public int classId() {
		return 124;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int channelid;
	public int targetid;
	public String message;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public ChannelChatPacket() {
		// Nothing here
	}

	public ChannelChatPacket(int channelid, int targetid, String message) {
		this.channelid = channelid;
		this.targetid = targetid;
		this.message = message;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(channelid);
		ps.saveInt(targetid);
		ps.saveString(message);
	}

	public void load(PacketInputStream ps) throws IOException {
		channelid = ps.loadInt();
		targetid = ps.loadInt();
		message = ps.loadString();
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("ChannelChatPacket :");
		result.append(" channelid[" + channelid + "]");
		result.append(" targetid[" + targetid + "]");
		result.append(" message[" + message + "]");
		return result.toString();
	}
}