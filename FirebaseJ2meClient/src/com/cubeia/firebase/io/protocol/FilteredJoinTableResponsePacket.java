// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:14 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   FilteredJoinTableResponsePacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Enums

public final class FilteredJoinTableResponsePacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 171;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public FilteredJoinTableResponsePacket()
    {
        status = Enums.makeFilteredJoinResponseStatus(0);
    }

    public FilteredJoinTableResponsePacket(int seq, int gameid, String address, Enums.FilteredJoinResponseStatus status)
    {
        this.status = Enums.makeFilteredJoinResponseStatus(0);
        this.seq = seq;
        this.gameid = gameid;
        this.address = address;
        this.status = status;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(seq);
        ps.saveInt(gameid);
        ps.saveString(address);
        ps.saveUnsignedByte(status.ordinal());
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        seq = ps.loadInt();
        gameid = ps.loadInt();
        address = ps.loadString();
        status = Enums.makeFilteredJoinResponseStatus(ps.loadUnsignedByte());
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("FilteredJoinTableResponsePacket :");
        result.append((new StringBuilder()).append(" seq[").append(seq).append("]").toString());
        result.append((new StringBuilder()).append(" gameid[").append(gameid).append("]").toString());
        result.append((new StringBuilder()).append(" address[").append(address).append("]").toString());
        result.append((new StringBuilder()).append(" status[").append(status).append("]").toString());
        return result.toString();
    }

    public int seq;
    public int gameid;
    public String address;
    public Enums.FilteredJoinResponseStatus status;
}