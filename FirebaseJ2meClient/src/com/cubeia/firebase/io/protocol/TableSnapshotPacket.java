// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:16 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TableSnapshotPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Param

public final class TableSnapshotPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 143;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public TableSnapshotPacket()
    {
    }

    public TableSnapshotPacket(int tableid, String address, String name, short capacity, short seated, List params)
    {
        this.tableid = tableid;
        this.address = address;
        this.name = name;
        this.capacity = capacity;
        this.seated = seated;
        this.params = params;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(tableid);
        ps.saveString(address);
        ps.saveString(name);
        ps.saveShort(capacity);
        ps.saveShort(seated);
        if(params == null)
        {
            ps.saveInt(0);
        } else
        {
            ps.saveInt(params.size());
            for(int i = 0; i != params.size(); i++)
                ((Param)params.get(i)).save(ps);

        }
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        tableid = ps.loadInt();
        address = ps.loadString();
        name = ps.loadString();
        capacity = ps.loadShort();
        seated = ps.loadShort();
        int paramsCount = ps.loadInt();
        params = new ArrayList(paramsCount);
        for(int i = 0; i != paramsCount; i++)
        {
            Param _tmp = new Param();
            _tmp.load(ps);
            params.add(_tmp);
        }

    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("TableSnapshotPacket :");
        result.append((new StringBuilder()).append(" tableid[").append(tableid).append("]").toString());
        result.append((new StringBuilder()).append(" address[").append(address).append("]").toString());
        result.append((new StringBuilder()).append(" name[").append(name).append("]").toString());
        result.append((new StringBuilder()).append(" capacity[").append(capacity).append("]").toString());
        result.append((new StringBuilder()).append(" seated[").append(seated).append("]").toString());
        result.append((new StringBuilder()).append(" params[").append(params).append("]").toString());
        return result.toString();
    }

    public int tableid;
    public String address;
    public String name;
    public short capacity;
    public short seated;
    public List params;
}