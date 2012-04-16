// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:15 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   NotifyRegisteredPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class NotifyRegisteredPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 211;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public NotifyRegisteredPacket()
    {
        tournaments = new int[0];
    }

    public NotifyRegisteredPacket(int tournaments[])
    {
        this.tournaments = new int[0];
        this.tournaments = tournaments;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(tournaments.length);
        ps.saveArray(tournaments);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        int tournamentsCount = ps.loadInt();
        tournaments = new int[tournamentsCount];
        ps.loadIntArray(tournaments);
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("NotifyRegisteredPacket :");
        result.append((new StringBuilder()).append(" tournaments[").append(tournaments).append("]").toString());
        return result.toString();
    }

    public int tournaments[];
}