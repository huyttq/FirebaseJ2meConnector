// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:14 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   KickPlayerPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class KickPlayerPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 64;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public KickPlayerPacket()
    {
    }

    public KickPlayerPacket(int tableid, short reasonCode)
    {
        this.tableid = tableid;
        this.reasonCode = reasonCode;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(tableid);
        ps.saveShort(reasonCode);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        tableid = ps.loadInt();
        reasonCode = ps.loadShort();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("KickPlayerPacket :");
        result.append((new StringBuilder()).append(" tableid[").append(tableid).append("]").toString());
        result.append((new StringBuilder()).append(" reasonCode[").append(reasonCode).append("]").toString());
        return result.toString();
    }

    public int tableid;
    public short reasonCode;
}