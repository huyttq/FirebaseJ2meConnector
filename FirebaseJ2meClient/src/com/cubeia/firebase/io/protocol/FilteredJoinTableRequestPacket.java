// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:14 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   FilteredJoinTableRequestPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, ParamFilter

public final class FilteredJoinTableRequestPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 170;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public FilteredJoinTableRequestPacket()
    {
    }

    public FilteredJoinTableRequestPacket(int seq, int gameid, String address, List params)
    {
        this.seq = seq;
        this.gameid = gameid;
        this.address = address;
        this.params = params;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(seq);
        ps.saveInt(gameid);
        ps.saveString(address);
        if(params == null)
        {
            ps.saveInt(0);
        } else
        {
            ps.saveInt(params.size());
            for(int i = 0; i != params.size(); i++)
                ((ParamFilter)params.get(i)).save(ps);

        }
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        seq = ps.loadInt();
        gameid = ps.loadInt();
        address = ps.loadString();
        int paramsCount = ps.loadInt();
        params = new ArrayList(paramsCount);
        for(int i = 0; i != paramsCount; i++)
        {
            ParamFilter _tmp = new ParamFilter();
            _tmp.load(ps);
            params.add(_tmp);
        }

    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("FilteredJoinTableRequestPacket :");
        result.append((new StringBuilder()).append(" seq[").append(seq).append("]").toString());
        result.append((new StringBuilder()).append(" gameid[").append(gameid).append("]").toString());
        result.append((new StringBuilder()).append(" address[").append(address).append("]").toString());
        result.append((new StringBuilder()).append(" params[").append(params).append("]").toString());
        return result.toString();
    }

    public int seq;
    public int gameid;
    public String address;
    public List params;
}