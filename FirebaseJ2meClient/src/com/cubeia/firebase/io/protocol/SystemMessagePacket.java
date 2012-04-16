// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:16 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   SystemMessagePacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class SystemMessagePacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 4;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public SystemMessagePacket()
    {
        pids = new int[0];
    }

    public SystemMessagePacket(int type, int level, String message, int pids[])
    {
        this.pids = new int[0];
        this.type = type;
        this.level = level;
        this.message = message;
        this.pids = pids;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(type);
        ps.saveInt(level);
        ps.saveString(message);
        ps.saveInt(pids.length);
        ps.saveArray(pids);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        type = ps.loadInt();
        level = ps.loadInt();
        message = ps.loadString();
        int pidsCount = ps.loadInt();
        pids = new int[pidsCount];
        ps.loadIntArray(pids);
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("SystemMessagePacket :");
        result.append((new StringBuilder()).append(" type[").append(type).append("]").toString());
        result.append((new StringBuilder()).append(" level[").append(level).append("]").toString());
        result.append((new StringBuilder()).append(" message[").append(message).append("]").toString());
        result.append((new StringBuilder()).append(" pids[").append(pids).append("]").toString());
        return result.toString();
    }

    public int type;
    public int level;
    public String message;
    public int pids[];
}