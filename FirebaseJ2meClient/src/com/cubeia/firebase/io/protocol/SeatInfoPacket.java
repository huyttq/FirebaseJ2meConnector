// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:16 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   SeatInfoPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, PlayerInfoPacket, Enums

public final class SeatInfoPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 15;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public SeatInfoPacket()
    {
        status = Enums.makePlayerStatus(0);
    }

    public SeatInfoPacket(int tableid, byte seat, Enums.PlayerStatus status, PlayerInfoPacket player)
    {
        this.status = Enums.makePlayerStatus(0);
        this.tableid = tableid;
        this.seat = seat;
        this.status = status;
        this.player = player;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(tableid);
        ps.saveByte(seat);
        ps.saveUnsignedByte(status.ordinal());
        player.save(ps);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        tableid = ps.loadInt();
        seat = ps.loadByte();
        status = Enums.makePlayerStatus(ps.loadUnsignedByte());
        player = new PlayerInfoPacket();
        player.load(ps);
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("SeatInfoPacket :");
        result.append((new StringBuilder()).append(" tableid[").append(tableid).append("]").toString());
        result.append((new StringBuilder()).append(" seat[").append(seat).append("]").toString());
        result.append((new StringBuilder()).append(" status[").append(status).append("]").toString());
        result.append((new StringBuilder()).append(" player[").append(player).append("]").toString());
        return result.toString();
    }

    public int tableid;
    public byte seat;
    public Enums.PlayerStatus status;
    public PlayerInfoPacket player;
}