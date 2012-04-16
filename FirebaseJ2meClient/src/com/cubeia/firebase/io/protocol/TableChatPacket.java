// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:16 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TableChatPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class TableChatPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 80;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public TableChatPacket()
    {
    }

    public TableChatPacket(int tableid, int pid, String message)
    {
        this.tableid = tableid;
        this.pid = pid;
        this.message = message;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(tableid);
        ps.saveInt(pid);
        ps.saveString(message);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        tableid = ps.loadInt();
        pid = ps.loadInt();
        message = ps.loadString();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("TableChatPacket :");
        result.append((new StringBuilder()).append(" tableid[").append(tableid).append("]").toString());
        result.append((new StringBuilder()).append(" pid[").append(pid).append("]").toString());
        result.append((new StringBuilder()).append(" message[").append(message).append("]").toString());
        return result.toString();
    }

    public int tableid;
    public int pid;
    public String message;
}