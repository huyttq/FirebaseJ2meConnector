// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:15 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   MttUnregisterRequestPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class MttUnregisterRequestPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 207;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public MttUnregisterRequestPacket()
    {
    }

    public MttUnregisterRequestPacket(int mttid)
    {
        this.mttid = mttid;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(mttid);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        mttid = ps.loadInt();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("MttUnregisterRequestPacket :");
        result.append((new StringBuilder()).append(" mttid[").append(mttid).append("]").toString());
        return result.toString();
    }

    public int mttid;
}