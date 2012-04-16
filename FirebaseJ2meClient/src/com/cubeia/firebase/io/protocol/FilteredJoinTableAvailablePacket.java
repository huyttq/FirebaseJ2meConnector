// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:14 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   FilteredJoinTableAvailablePacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class FilteredJoinTableAvailablePacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 174;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public FilteredJoinTableAvailablePacket()
    {
    }

    public FilteredJoinTableAvailablePacket(int seq, int tableid, byte seat)
    {
        this.seq = seq;
        this.tableid = tableid;
        this.seat = seat;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(seq);
        ps.saveInt(tableid);
        ps.saveByte(seat);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        seq = ps.loadInt();
        tableid = ps.loadInt();
        seat = ps.loadByte();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("FilteredJoinTableAvailablePacket :");
        result.append((new StringBuilder()).append(" seq[").append(seq).append("]").toString());
        result.append((new StringBuilder()).append(" tableid[").append(tableid).append("]").toString());
        result.append((new StringBuilder()).append(" seat[").append(seat).append("]").toString());
        return result.toString();
    }

    public int seq;
    public int tableid;
    public byte seat;
}