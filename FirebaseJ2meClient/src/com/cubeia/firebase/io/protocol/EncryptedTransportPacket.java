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

public final class EncryptedTransportPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 105;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public byte func;
	public byte[] payload = new byte[0];

	/**
	 * Default
	 * constructor.
	 *
	 */
	public EncryptedTransportPacket() {
		// Nothing here
	}

	public EncryptedTransportPacket(byte func, byte[] payload) {
		this.func = func;
		this.payload = payload;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveByte(func);
		ps.saveInt(payload.length);
		ps.saveArray(payload);
	}

	public void load(PacketInputStream ps) throws IOException {
		func = ps.loadByte();
		int payloadCount = ps.loadInt();
		payload = new byte[payloadCount];
		ps.loadByteArray(payload);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("EncryptedTransportPacket :");
		result.append(" func[" + func + "]");
		result.append(" payload[" + ArrayUtils.toString(payload, 20) + "]");
		return result.toString();
	}
}
