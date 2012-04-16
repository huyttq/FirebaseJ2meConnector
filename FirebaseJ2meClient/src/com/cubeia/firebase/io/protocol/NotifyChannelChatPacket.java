// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:15 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   NotifyChannelChatPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class NotifyChannelChatPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 123;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public NotifyChannelChatPacket()
    {
    }

    public NotifyChannelChatPacket(int pid, int channelid, int targetid, String nick, String message)
    {
        this.pid = pid;
        this.channelid = channelid;
        this.targetid = targetid;
        this.nick = nick;
        this.message = message;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(pid);
        ps.saveInt(channelid);
        ps.saveInt(targetid);
        ps.saveString(nick);
        ps.saveString(message);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        pid = ps.loadInt();
        channelid = ps.loadInt();
        targetid = ps.loadInt();
        nick = ps.loadString();
        message = ps.loadString();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("NotifyChannelChatPacket :");
        result.append((new StringBuilder()).append(" pid[").append(pid).append("]").toString());
        result.append((new StringBuilder()).append(" channelid[").append(channelid).append("]").toString());
        result.append((new StringBuilder()).append(" targetid[").append(targetid).append("]").toString());
        result.append((new StringBuilder()).append(" nick[").append(nick).append("]").toString());
        result.append((new StringBuilder()).append(" message[").append(message).append("]").toString());
        return result.toString();
    }

    public int pid;
    public int channelid;
    public int targetid;
    public String nick;
    public String message;
}