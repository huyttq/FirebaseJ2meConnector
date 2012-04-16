// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:16 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   PlayerQueryRequestPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class PlayerQueryRequestPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 16;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public PlayerQueryRequestPacket()
    {
    }

    public PlayerQueryRequestPacket(int pid)
    {
        this.pid = pid;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(pid);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        pid = ps.loadInt();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("PlayerQueryRequestPacket :");
        result.append((new StringBuilder()).append(" pid[").append(pid).append("]").toString());
        return result.toString();
    }

    public int pid;
}