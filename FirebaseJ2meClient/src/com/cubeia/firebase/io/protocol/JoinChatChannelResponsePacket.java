// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:14 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   JoinChatChannelResponsePacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Enums

public final class JoinChatChannelResponsePacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 121;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public JoinChatChannelResponsePacket()
    {
        status = Enums.makeResponseStatus(0);
    }

    public JoinChatChannelResponsePacket(int channelid, Enums.ResponseStatus status)
    {
        this.status = Enums.makeResponseStatus(0);
        this.channelid = channelid;
        this.status = status;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(channelid);
        ps.saveUnsignedByte(status.ordinal());
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        channelid = ps.loadInt();
        status = Enums.makeResponseStatus(ps.loadUnsignedByte());
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("JoinChatChannelResponsePacket :");
        result.append((new StringBuilder()).append(" channelid[").append(channelid).append("]").toString());
        result.append((new StringBuilder()).append(" status[").append(status).append("]").toString());
        return result.toString();
    }

    public int channelid;
    public Enums.ResponseStatus status;
}