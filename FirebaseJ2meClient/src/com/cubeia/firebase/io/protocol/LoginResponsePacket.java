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

public final class LoginResponsePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 11;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public String screenname;
	public int pid;
	public Enums.ResponseStatus status = Enums.makeResponseStatus(0);
	public int code;
	public String message;
	public byte[] credentials = new byte[0];

	/**
	 * Default
	 * constructor.
	 *
	 */
	public LoginResponsePacket() {
		// Nothing here
	}

	public LoginResponsePacket(String screenname, int pid, Enums.ResponseStatus status, int code, String message, byte[] credentials) {
		this.screenname = screenname;
		this.pid = pid;
		this.status = status;
		this.code = code;
		this.message = message;
		this.credentials = credentials;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveString(screenname);
		ps.saveInt(pid);
		ps.saveUnsignedByte(status.ordinal());
		ps.saveInt(code);
		ps.saveString(message);
		ps.saveInt(credentials.length);
		ps.saveArray(credentials);
	}

	public void load(PacketInputStream ps) throws IOException {
		screenname = ps.loadString();
		pid = ps.loadInt();
		status = Enums.makeResponseStatus(ps.loadUnsignedByte());
		code = ps.loadInt();
		message = ps.loadString();
		int credentialsCount = ps.loadInt();
		credentials = new byte[credentialsCount];
		ps.loadByteArray(credentials);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("LoginResponsePacket :");
		result.append(" screenname[" + screenname + "]");
		result.append(" pid[" + pid + "]");
		result.append(" status[" + status + "]");
		result.append(" code[" + code + "]");
		result.append(" message[" + message + "]");
		result.append(" credentials[" + ArrayUtils.toString(credentials, 20) + "]");
		return result.toString();
	}
}
