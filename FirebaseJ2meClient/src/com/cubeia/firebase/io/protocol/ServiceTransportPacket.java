// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:16 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ServiceTransportPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import com.cubeia.firebase.styx.util.ArrayUtils;
import j2me.lang.StringBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Attribute

public final class ServiceTransportPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 101;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public ServiceTransportPacket()
    {
        servicedata = new byte[0];
    }

    public ServiceTransportPacket(int pid, int seq, String service, byte idtype, byte servicedata[], List attributes)
    {
        this.servicedata = new byte[0];
        this.pid = pid;
        this.seq = seq;
        this.service = service;
        this.idtype = idtype;
        this.servicedata = servicedata;
        this.attributes = attributes;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(pid);
        ps.saveInt(seq);
        ps.saveString(service);
        ps.saveByte(idtype);
        ps.saveInt(servicedata.length);
        ps.saveArray(servicedata);
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
        pid = ps.loadInt();
        seq = ps.loadInt();
        service = ps.loadString();
        idtype = ps.loadByte();
        int servicedataCount = ps.loadInt();
        servicedata = new byte[servicedataCount];
        ps.loadByteArray(servicedata);
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
				result.append("ServiceTransportPacket :");
        result.append((new StringBuilder()).append(" pid[").append(pid).append("]").toString());
        result.append((new StringBuilder()).append(" seq[").append(seq).append("]").toString());
        result.append((new StringBuilder()).append(" service[").append(service).append("]").toString());
        result.append((new StringBuilder()).append(" idtype[").append(idtype).append("]").toString());
        result.append((new StringBuilder()).append(" servicedata[").append(ArrayUtils.toString(servicedata, 20)).append("]").toString());
        result.append((new StringBuilder()).append(" attributes[").append(attributes).append("]").toString());
        return result.toString();
    }

    public int pid;
    public int seq;
    public String service;
    public byte idtype;
    public byte servicedata[];
    public List attributes;
}