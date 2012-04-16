// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:16 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   PlayerInfoPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Param

public final class PlayerInfoPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 13;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public PlayerInfoPacket()
    {
    }

    public PlayerInfoPacket(int pid, String nick, List details)
    {
        this.pid = pid;
        this.nick = nick;
        this.details = details;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(pid);
        ps.saveString(nick);
        if(details == null)
        {
            ps.saveInt(0);
        } else
        {
            ps.saveInt(details.size());
            for(int i = 0; i != details.size(); i++)
                ((Param)details.get(i)).save(ps);

        }
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        pid = ps.loadInt();
        nick = ps.loadString();
        int detailsCount = ps.loadInt();
        details = new ArrayList(detailsCount);
        for(int i = 0; i != detailsCount; i++)
        {
            Param _tmp = new Param();
            _tmp.load(ps);
            details.add(_tmp);
        }

    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("PlayerInfoPacket :");
        result.append((new StringBuilder()).append(" pid[").append(pid).append("]").toString());
        result.append((new StringBuilder()).append(" nick[").append(nick).append("]").toString());
        result.append((new StringBuilder()).append(" details[").append(details).append("]").toString());
        return result.toString();
    }

    public int pid;
    public String nick;
    public List details;
}