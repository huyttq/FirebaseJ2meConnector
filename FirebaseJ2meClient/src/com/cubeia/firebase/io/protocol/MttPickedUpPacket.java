// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:15 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   MttPickedUpPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class MttPickedUpPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 210;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public MttPickedUpPacket()
    {
    }

    public MttPickedUpPacket(int mttid, int tableid, boolean keepWatching)
    {
        this.mttid = mttid;
        this.tableid = tableid;
        this.keepWatching = keepWatching;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(mttid);
        ps.saveInt(tableid);
        ps.saveBoolean(keepWatching);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        mttid = ps.loadInt();
        tableid = ps.loadInt();
        keepWatching = ps.loadBoolean();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("MttPickedUpPacket :");
        result.append((new StringBuilder()).append(" mttid[").append(mttid).append("]").toString());
        result.append((new StringBuilder()).append(" tableid[").append(tableid).append("]").toString());
        result.append((new StringBuilder()).append(" keep_watching[").append(keepWatching).append("]").toString());
        return result.toString();
    }

    public int mttid;
    public int tableid;
    public boolean keepWatching;
}