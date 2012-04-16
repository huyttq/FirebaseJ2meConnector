// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:16 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ProbePacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, ProbeStamp

public final class ProbePacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 201;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public ProbePacket()
    {
    }

    public ProbePacket(int id, int tableid, List stamps)
    {
        this.id = id;
        this.tableid = tableid;
        this.stamps = stamps;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(id);
        ps.saveInt(tableid);
        if(stamps == null)
        {
            ps.saveInt(0);
        } else
        {
            ps.saveInt(stamps.size());
            for(int i = 0; i != stamps.size(); i++)
                ((ProbeStamp)stamps.get(i)).save(ps);

        }
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        id = ps.loadInt();
        tableid = ps.loadInt();
        int stampsCount = ps.loadInt();
        stamps = new ArrayList(stampsCount);
        for(int i = 0; i != stampsCount; i++)
        {
            ProbeStamp _tmp = new ProbeStamp();
            _tmp.load(ps);
            stamps.add(_tmp);
        }

    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("ProbePacket :");
        result.append((new StringBuilder()).append(" id[").append(id).append("]").toString());
        result.append((new StringBuilder()).append(" tableid[").append(tableid).append("]").toString());
        result.append((new StringBuilder()).append(" stamps[").append(stamps).append("]").toString());
        return result.toString();
    }

    public int id;
    public int tableid;
    public List stamps;
}