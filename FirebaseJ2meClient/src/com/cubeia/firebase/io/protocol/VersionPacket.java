// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:17 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   VersionPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class VersionPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 0;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public VersionPacket()
    {
    }

    public VersionPacket(int game, int operatorid, int protocol)
    {
        this.game = game;
        this.operatorid = operatorid;
        this.protocol = protocol;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(game);
        ps.saveInt(operatorid);
        ps.saveInt(protocol);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        game = ps.loadInt();
        operatorid = ps.loadInt();
        protocol = ps.loadInt();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("VersionPacket :");
        result.append((new StringBuilder()).append(" game[").append(game).append("]").toString());
        result.append((new StringBuilder()).append(" operatorid[").append(operatorid).append("]").toString());
        result.append((new StringBuilder()).append(" protocol[").append(protocol).append("]").toString());
        return result.toString();
    }

    public int game;
    public int operatorid;
    public int protocol;
}