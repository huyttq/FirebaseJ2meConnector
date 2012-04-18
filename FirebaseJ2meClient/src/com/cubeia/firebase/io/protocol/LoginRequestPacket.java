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

public final class LoginRequestPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 10;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public String user;
	public String password;
	public int operatorid;
	public byte[] credentials = new byte[0];

	/**
	 * Default
	 * constructor.
	 *
	 */
	public LoginRequestPacket() {
		// Nothing here
	}

	public LoginRequestPacket(String user, String password, int operatorid, byte[] credentials) {
		this.user = user;
		this.password = password;
		this.operatorid = operatorid;
		this.credentials = credentials;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveString(user);
		ps.saveString(password);
		ps.saveInt(operatorid);
		ps.saveInt(credentials.length);
		ps.saveArray(credentials);
	}

	public void load(PacketInputStream ps) throws IOException {
		user = ps.loadString();
		password = ps.loadString();
		operatorid = ps.loadInt();
		int credentialsCount = ps.loadInt();
		credentials = new byte[credentialsCount];
		ps.loadByteArray(credentials);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("LoginRequestPacket :");
		result.append(" user[" + user + "]");
		result.append(" password[" + password + "]");
		result.append(" operatorid[" + operatorid + "]");
		result.append(" credentials[" + ArrayUtils.toString(credentials, 20) + "]");
		return result.toString();
	}
}
