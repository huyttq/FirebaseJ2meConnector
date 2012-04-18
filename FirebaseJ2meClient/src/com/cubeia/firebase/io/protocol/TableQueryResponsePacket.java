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

public final class TableQueryResponsePacket implements ProtocolObject, Visitable {

	public int classId() {
		return 39;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int tableid;
	public Enums.ResponseStatus status = Enums.makeResponseStatus(0);
	public List seats;

	/**
	 * Default
	 * constructor.
	 *
	 */
	public TableQueryResponsePacket() {
		// Nothing here
	}

	public TableQueryResponsePacket(int tableid, Enums.ResponseStatus status, List seats) {
		this.tableid = tableid;
		this.status = status;
		this.seats = seats;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(tableid);
		ps.saveUnsignedByte(status.ordinal());
		if (seats == null) {
			ps.saveInt(0);
		} else {
			ps.saveInt(seats.size());
			for (int i = 0; i != seats.size(); ++i) {
				((SeatInfoPacket) seats.get(i)).save(ps);
			}
		}
	}

	public void load(PacketInputStream ps) throws IOException {
		tableid = ps.loadInt();
		status = Enums.makeResponseStatus(ps.loadUnsignedByte());
		int seatsCount = ps.loadInt();
		seats = new ArrayList(seatsCount);
		for (int i = 0; i != seatsCount; ++i) {
			SeatInfoPacket _tmp = new SeatInfoPacket();
			_tmp.load(ps);
			seats.add(_tmp);
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("TableQueryResponsePacket :");
		result.append(" tableid[" + tableid + "]");
		result.append(" status[" + status + "]");
		result.append(" seats[" + seats + "]");
		return result.toString();
	}
}
