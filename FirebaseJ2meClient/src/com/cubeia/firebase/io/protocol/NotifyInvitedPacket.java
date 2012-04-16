// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:15 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   NotifyInvitedPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class NotifyInvitedPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 43;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public NotifyInvitedPacket()
    {
    }

    public NotifyInvitedPacket(int inviter, String screenname, int tableid, byte seat)
    {
        this.inviter = inviter;
        this.screenname = screenname;
        this.tableid = tableid;
        this.seat = seat;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(inviter);
        ps.saveString(screenname);
        ps.saveInt(tableid);
        ps.saveByte(seat);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        inviter = ps.loadInt();
        screenname = ps.loadString();
        tableid = ps.loadInt();
        seat = ps.loadByte();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("NotifyInvitedPacket :");
        result.append((new StringBuilder()).append(" inviter[").append(inviter).append("]").toString());
        result.append((new StringBuilder()).append(" screenname[").append(screenname).append("]").toString());
        result.append((new StringBuilder()).append(" tableid[").append(tableid).append("]").toString());
        result.append((new StringBuilder()).append(" seat[").append(seat).append("]").toString());
        return result.toString();
    }

    public int inviter;
    public String screenname;
    public int tableid;
    public byte seat;
}