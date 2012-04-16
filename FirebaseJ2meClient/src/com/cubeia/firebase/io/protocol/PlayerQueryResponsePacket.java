// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:16 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   PlayerQueryResponsePacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import com.cubeia.firebase.styx.util.ArrayUtils;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Enums

public final class PlayerQueryResponsePacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 17;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public PlayerQueryResponsePacket()
    {
        status = Enums.makeResponseStatus(0);
        data = new byte[0];
    }

    public PlayerQueryResponsePacket(int pid, String nick, Enums.ResponseStatus status, byte data[])
    {
        this.status = Enums.makeResponseStatus(0);
        this.data = new byte[0];
        this.pid = pid;
        this.nick = nick;
        this.status = status;
        this.data = data;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(pid);
        ps.saveString(nick);
        ps.saveUnsignedByte(status.ordinal());
        ps.saveInt(data.length);
        ps.saveArray(data);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        pid = ps.loadInt();
        nick = ps.loadString();
        status = Enums.makeResponseStatus(ps.loadUnsignedByte());
        int dataCount = ps.loadInt();
        data = new byte[dataCount];
        ps.loadByteArray(data);
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("PlayerQueryResponsePacket :");
        result.append((new StringBuilder()).append(" pid[").append(pid).append("]").toString());
        result.append((new StringBuilder()).append(" nick[").append(nick).append("]").toString());
        result.append((new StringBuilder()).append(" status[").append(status).append("]").toString());
        result.append((new StringBuilder()).append(" data[").append(ArrayUtils.toString(data, 20)).append("]").toString());
        return result.toString();
    }

    public int pid;
    public String nick;
    public Enums.ResponseStatus status;
    public byte data[];
}