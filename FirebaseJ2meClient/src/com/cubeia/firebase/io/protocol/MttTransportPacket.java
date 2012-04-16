// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:15 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   MttTransportPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import com.cubeia.firebase.styx.util.ArrayUtils;
import j2me.lang.StringBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Attribute

public final class MttTransportPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 104;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public MttTransportPacket()
    {
        mttdata = new byte[0];
    }

    public MttTransportPacket(int mttid, int pid, byte mttdata[], List attributes)
    {
        this.mttdata = new byte[0];
        this.mttid = mttid;
        this.pid = pid;
        this.mttdata = mttdata;
        this.attributes = attributes;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(mttid);
        ps.saveInt(pid);
        ps.saveInt(mttdata.length);
        ps.saveArray(mttdata);
        if(attributes == null)
        {
            ps.saveInt(0);
        } else
        {
            ps.saveInt(attributes.size());
            for(int i = 0; i != attributes.size(); i++)
                ((Attribute)attributes.get(i)).save(ps);

        }
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        mttid = ps.loadInt();
        pid = ps.loadInt();
        int mttdataCount = ps.loadInt();
        mttdata = new byte[mttdataCount];
        ps.loadByteArray(mttdata);
        int attributesCount = ps.loadInt();
        attributes = new ArrayList(attributesCount);
        for(int i = 0; i != attributesCount; i++)
        {
            Attribute _tmp = new Attribute();
            _tmp.load(ps);
            attributes.add(_tmp);
        }

    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("MttTransportPacket :");
        result.append((new StringBuilder()).append(" mttid[").append(mttid).append("]").toString());
        result.append((new StringBuilder()).append(" pid[").append(pid).append("]").toString());
        result.append((new StringBuilder()).append(" mttdata[").append(ArrayUtils.toString(mttdata, 20)).append("]").toString());
        result.append((new StringBuilder()).append(" attributes[").append(attributes).append("]").toString());
        return result.toString();
    }

    public int mttid;
    public int pid;
    public byte mttdata[];
    public List attributes;
}