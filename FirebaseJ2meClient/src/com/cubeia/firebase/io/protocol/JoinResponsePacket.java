// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:14 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   JoinResponsePacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Enums

public final class JoinResponsePacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 31;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public JoinResponsePacket()
    {
        status = Enums.makeJoinResponseStatus(0);
    }

    public JoinResponsePacket(int tableid, byte seat, Enums.JoinResponseStatus status, int code)
    {
        this.status = Enums.makeJoinResponseStatus(0);
        this.tableid = tableid;
        this.seat = seat;
        this.status = status;
        this.code = code;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(tableid);
        ps.saveByte(seat);
        ps.saveUnsignedByte(status.ordinal());
        ps.saveInt(code);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        tableid = ps.loadInt();
        seat = ps.loadByte();
        status = Enums.makeJoinResponseStatus(ps.loadUnsignedByte());
        code = ps.loadInt();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("JoinResponsePacket :");
        result.append((new StringBuilder()).append(" tableid[").append(tableid).append("]").toString());
        result.append((new StringBuilder()).append(" seat[").append(seat).append("]").toString());
        result.append((new StringBuilder()).append(" status[").append(status).append("]").toString());
        result.append((new StringBuilder()).append(" code[").append(code).append("]").toString());
        return result.toString();
    }

    public int tableid;
    public byte seat;
    public Enums.JoinResponseStatus status;
    public int code;
}