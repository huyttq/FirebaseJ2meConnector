// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:16 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ProbeStamp.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class ProbeStamp
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 200;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public ProbeStamp()
    {
    }

    public ProbeStamp(String clazz, long timestamp)
    {
        this.clazz = clazz;
        this.timestamp = timestamp;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveString(clazz);
        ps.saveLong(timestamp);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        clazz = ps.loadString();
        timestamp = ps.loadLong();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("ProbeStamp :");
        result.append((new StringBuilder()).append(" clazz[").append(clazz).append("]").toString());
        result.append((new StringBuilder()).append(" timestamp[").append(timestamp).append("]").toString());
        return result.toString();
    }

    public String clazz;
    public long timestamp;
}