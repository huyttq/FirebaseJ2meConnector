// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:14 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ForcedLogoutPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class ForcedLogoutPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 14;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public ForcedLogoutPacket()
    {
    }

    public ForcedLogoutPacket(int code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(code);
        ps.saveString(message);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        code = ps.loadInt();
        message = ps.loadString();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("ForcedLogoutPacket :");
        result.append((new StringBuilder()).append(" code[").append(code).append("]").toString());
        result.append((new StringBuilder()).append(" message[").append(message).append("]").toString());
        return result.toString();
    }

    public int code;
    public String message;
}