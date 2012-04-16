// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:16 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TournamentSnapshotPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Param

public final class TournamentSnapshotPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 148;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public TournamentSnapshotPacket()
    {
    }

    public TournamentSnapshotPacket(int mttid, String address, List params)
    {
        this.mttid = mttid;
        this.address = address;
        this.params = params;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(mttid);
        ps.saveString(address);
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
        mttid = ps.loadInt();
        address = ps.loadString();
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
				result.append("TournamentSnapshotPacket :");
        result.append((new StringBuilder()).append(" mttid[").append(mttid).append("]").toString());
        result.append((new StringBuilder()).append(" address[").append(address).append("]").toString());
        result.append((new StringBuilder()).append(" params[").append(params).append("]").toString());
        return result.toString();
    }

    public int mttid;
    public String address;
    public List params;
}