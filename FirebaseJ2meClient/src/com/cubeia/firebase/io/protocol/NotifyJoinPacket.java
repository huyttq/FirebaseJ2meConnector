// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:15 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   NotifyJoinPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class NotifyJoinPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 60;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public NotifyJoinPacket()
    {
    }

    public NotifyJoinPacket(int tableid, int pid, String nick, byte seat)
    {
        this.tableid = tableid;
        this.pid = pid;
        this.nick = nick;
        this.seat = seat;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(tableid);
        ps.saveInt(pid);
        ps.saveString(nick);
        ps.saveByte(seat);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        tableid = ps.loadInt();
        pid = ps.loadInt();
        nick = ps.loadString();
        seat = ps.loadByte();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("NotifyJoinPacket :");
        result.append((new StringBuilder()).append(" tableid[").append(tableid).append("]").toString());
        result.append((new StringBuilder()).append(" pid[").append(pid).append("]").toString());
        result.append((new StringBuilder()).append(" nick[").append(nick).append("]").toString());
        result.append((new StringBuilder()).append(" seat[").append(seat).append("]").toString());
        return result.toString();
    }

    public int tableid;
    public int pid;
    public String nick;
    public byte seat;
}