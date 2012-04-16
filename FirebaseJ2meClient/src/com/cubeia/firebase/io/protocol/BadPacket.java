// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:13 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   BadPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class BadPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 3;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public BadPacket()
    {
    }

    public BadPacket(byte cmd, byte error)
    {
        this.cmd = cmd;
        this.error = error;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveByte(cmd);
        ps.saveByte(error);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        cmd = ps.loadByte();
        error = ps.loadByte();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("BadPacket :");
        result.append((new StringBuilder()).append(" cmd[").append(cmd).append("]").toString());
        result.append((new StringBuilder()).append(" error[").append(error).append("]").toString());
        return result.toString();
    }

    public byte cmd;
    public byte error;
}