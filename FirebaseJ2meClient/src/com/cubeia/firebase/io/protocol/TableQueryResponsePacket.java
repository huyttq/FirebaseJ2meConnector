// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:16 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TableQueryResponsePacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, SeatInfoPacket, Enums

public final class TableQueryResponsePacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 39;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public TableQueryResponsePacket()
    {
        status = Enums.makeResponseStatus(0);
    }

    public TableQueryResponsePacket(int tableid, Enums.ResponseStatus status, List seats)
    {
        this.status = Enums.makeResponseStatus(0);
        this.tableid = tableid;
        this.status = status;
        this.seats = seats;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(tableid);
        ps.saveUnsignedByte(status.ordinal());
        if(seats == null)
        {
            ps.saveInt(0);
        } else
        {
            ps.saveInt(seats.size());
            for(int i = 0; i != seats.size(); i++)
                ((SeatInfoPacket)seats.get(i)).save(ps);

        }
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        tableid = ps.loadInt();
        status = Enums.makeResponseStatus(ps.loadUnsignedByte());
        int seatsCount = ps.loadInt();
        seats = new ArrayList(seatsCount);
        for(int i = 0; i != seatsCount; i++)
        {
            SeatInfoPacket _tmp = new SeatInfoPacket();
            _tmp.load(ps);
            seats.add(_tmp);
        }

    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("TableQueryResponsePacket :");
        result.append((new StringBuilder()).append(" tableid[").append(tableid).append("]").toString());
        result.append((new StringBuilder()).append(" status[").append(status).append("]").toString());
        result.append((new StringBuilder()).append(" seats[").append(seats).append("]").toString());
        return result.toString();
    }

    public int tableid;
    public Enums.ResponseStatus status;
    public List seats;
}