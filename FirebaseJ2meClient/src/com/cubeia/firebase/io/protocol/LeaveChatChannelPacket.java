// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:14 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   LeaveChatChannelPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class LeaveChatChannelPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 122;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public LeaveChatChannelPacket()
    {
    }

    public LeaveChatChannelPacket(int channelid)
    {
        this.channelid = channelid;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(channelid);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        channelid = ps.loadInt();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("LeaveChatChannelPacket :");
        result.append((new StringBuilder()).append(" channelid[").append(channelid).append("]").toString());
        return result.toString();
    }

    public int channelid;
}