// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.PacketInputStream;
import com.cubeia.firebase.io.PacketOutputStream;
import com.cubeia.firebase.io.ProtocolObject;
import com.cubeia.firebase.io.ProtocolObjectVisitor;
import com.cubeia.firebase.io.Visitable;
import j2me.lang.StringBuilder;
import java.io.IOException;

public final class SeatInfoPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 15;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int tableid;
	public byte seat;
	public Enums.PlayerStatus status = Enums.makePlayerStatus(0);
	public PlayerInfoPacket player;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public SeatInfoPacket() {
		// Nothing here
	}

	public SeatInfoPacket(int tableid, byte seat, Enums.PlayerStatus status, PlayerInfoPacket player) {
		this.tableid = tableid;
		this.seat = seat;
		this.status = status;
		this.player = player;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(tableid);
		ps.saveByte(seat);
		ps.saveUnsignedByte(status.ordinal());
		player.save(ps);
	}

	public void load(PacketInputStream ps) throws IOException {
		tableid = ps.loadInt();
		seat = ps.loadByte();
		status = Enums.makePlayerStatus(ps.loadUnsignedByte());
		player = new PlayerInfoPacket();
		player.load(ps);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("SeatInfoPacket :");
		result.append(" tableid[" + tableid + "]");
		result.append(" seat[" + seat + "]");
		result.append(" status[" + status + "]");
		result.append(" player[" + player + "]");
		return result.toString();
	}
}
