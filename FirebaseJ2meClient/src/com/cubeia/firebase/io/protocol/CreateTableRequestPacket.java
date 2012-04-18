// I AM AUTO-GENERATED, DON'T CHECK ME INTO SUBVERSION (or else...)
package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class CreateTableRequestPacket implements ProtocolObject, Visitable {

	public int classId() {
		return 40;
	}

	public void accept(ProtocolObjectVisitor visitor) {
		if (visitor instanceof PacketVisitor) {
			PacketVisitor handler = (PacketVisitor) visitor;
			handler.visit(this);
		}
	}
	public int seq;
	public int gameid;
	public byte seats;
	public List params;
	public int[] invitees = new int[0];

	/**
	 * Default
	 * constructor.
	 *
	 */
	public CreateTableRequestPacket() {
		// Nothing here
	}

	public CreateTableRequestPacket(int seq, int gameid, byte seats, List params, int[] invitees) {
		this.seq = seq;
		this.gameid = gameid;
		this.seats = seats;
		this.params = params;
		this.invitees = invitees;
	}

	public void save(PacketOutputStream ps) throws IOException {
		ps.saveInt(seq);
		ps.saveInt(gameid);
		ps.saveByte(seats);
		if (params == null) {
			ps.saveInt(0);
		} else {
			ps.saveInt(params.size());
			for (int i = 0; i != params.size(); ++i) {
				((Param)params.get(i)).save(ps);
			}
		}
		ps.saveInt(invitees.length);
		ps.saveArray(invitees);
	}

	public void load(PacketInputStream ps) throws IOException {
		seq = ps.loadInt();
		gameid = ps.loadInt();
		seats = ps.loadByte();
		int paramsCount = ps.loadInt();
		params = new ArrayList(paramsCount);
		for (int i = 0; i != paramsCount; ++i) {
			Param _tmp = new Param();
			_tmp.load(ps);
			params.add(_tmp);
		}
		int inviteesCount = ps.loadInt();
		invitees = new int[inviteesCount];
		ps.loadIntArray(invitees);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("CreateTableRequestPacket :");
		result.append(" seq[" + seq + "]");
		result.append(" gameid[" + gameid + "]");
		result.append(" seats[" + seats + "]");
		result.append(" params[" + params + "]");
		result.append(" invitees[" + invitees + "]");
		return result.toString();
	}
}
