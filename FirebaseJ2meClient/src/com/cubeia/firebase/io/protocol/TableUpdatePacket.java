// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:16 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TableUpdatePacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Param

public final class TableUpdatePacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 144;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public TableUpdatePacket()
    {
        removedParams = new String[0];
    }

    public TableUpdatePacket(int tableid, short seated, List params, String removedParams[])
    {
        this.removedParams = new String[0];
        this.tableid = tableid;
        this.seated = seated;
        this.params = params;
        this.removedParams = removedParams;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(tableid);
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
        ps.saveInt(removedParams.length);
        ps.saveArray(removedParams);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        tableid = ps.loadInt();
        seated = ps.loadShort();
        int paramsCount = ps.loadInt();
        params = new ArrayList(paramsCount);
        for(int i = 0; i != paramsCount; i++)
        {
            Param _tmp = new Param();
            _tmp.load(ps);
            params.add(_tmp);
        }

        int removedParamsCount = ps.loadInt();
        removedParams = new String[removedParamsCount];
        ps.loadStringArray(removedParams);
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("TableUpdatePacket :");
        result.append((new StringBuilder()).append(" tableid[").append(tableid).append("]").toString());
        result.append((new StringBuilder()).append(" seated[").append(seated).append("]").toString());
        result.append((new StringBuilder()).append(" params[").append(params).append("]").toString());
        result.append((new StringBuilder()).append(" removed_params[").append(removedParams).append("]").toString());
        return result.toString();
    }

    public int tableid;
    public short seated;
    public List params;
    public String removedParams[];
}