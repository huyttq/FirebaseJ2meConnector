// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:15 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   LocalServiceTransportPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import com.cubeia.firebase.styx.util.ArrayUtils;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class LocalServiceTransportPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 103;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public LocalServiceTransportPacket()
    {
        servicedata = new byte[0];
    }

    public LocalServiceTransportPacket(int seq, byte servicedata[])
    {
        this.servicedata = new byte[0];
        this.seq = seq;
        this.servicedata = servicedata;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(seq);
        ps.saveInt(servicedata.length);
        ps.saveArray(servicedata);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        seq = ps.loadInt();
        int servicedataCount = ps.loadInt();
        servicedata = new byte[servicedataCount];
        ps.loadByteArray(servicedata);
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("LocalServiceTransportPacket :");
        result.append((new StringBuilder()).append(" seq[").append(seq).append("]").toString());
        result.append((new StringBuilder()).append(" servicedata[").append(ArrayUtils.toString(servicedata, 20)).append("]").toString());
        return result.toString();
    }

    public int seq;
    public byte servicedata[];
}