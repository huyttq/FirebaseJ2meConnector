// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:17 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   UnwatchResponsePacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Enums

public final class UnwatchResponsePacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 35;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public UnwatchResponsePacket()
    {
        status = Enums.makeResponseStatus(0);
    }

    public UnwatchResponsePacket(int tableid, Enums.ResponseStatus status)
    {
        this.status = Enums.makeResponseStatus(0);
        this.tableid = tableid;
        this.status = status;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(tableid);
        ps.saveUnsignedByte(status.ordinal());
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        tableid = ps.loadInt();
        status = Enums.makeResponseStatus(ps.loadUnsignedByte());
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("UnwatchResponsePacket :");
        result.append((new StringBuilder()).append(" tableid[").append(tableid).append("]").toString());
        result.append((new StringBuilder()).append(" status[").append(status).append("]").toString());
        return result.toString();
    }

    public int tableid;
    public Enums.ResponseStatus status;
}