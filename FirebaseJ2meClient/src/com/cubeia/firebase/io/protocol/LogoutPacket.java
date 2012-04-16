// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:15 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   LogoutPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class LogoutPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 12;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public LogoutPacket()
    {
    }

    public LogoutPacket(boolean leaveTables)
    {
        this.leaveTables = leaveTables;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveBoolean(leaveTables);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        leaveTables = ps.loadBoolean();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("LogoutPacket :");
        result.append((new StringBuilder()).append(" leave_tables[").append(leaveTables).append("]").toString());
        return result.toString();
    }

    public boolean leaveTables;
}