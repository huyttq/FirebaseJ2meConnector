// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:14 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   GameVersionPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class GameVersionPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 1;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public GameVersionPacket()
    {
    }

    public GameVersionPacket(int game, int operatorid, String version)
    {
        this.game = game;
        this.operatorid = operatorid;
        this.version = version;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(game);
        ps.saveInt(operatorid);
        ps.saveString(version);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        game = ps.loadInt();
        operatorid = ps.loadInt();
        version = ps.loadString();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("GameVersionPacket :");
        result.append((new StringBuilder()).append(" game[").append(game).append("]").toString());
        result.append((new StringBuilder()).append(" operatorid[").append(operatorid).append("]").toString());
        result.append((new StringBuilder()).append(" version[").append(version).append("]").toString());
        return result.toString();
    }

    public int game;
    public int operatorid;
    public String version;
}