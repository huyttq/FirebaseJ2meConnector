// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:17 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TournamentUpdatePacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Param

public final class TournamentUpdatePacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 149;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public TournamentUpdatePacket()
    {
        removedParams = new String[0];
    }

    public TournamentUpdatePacket(int mttid, List params, String removedParams[])
    {
        this.removedParams = new String[0];
        this.mttid = mttid;
        this.params = params;
        this.removedParams = removedParams;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(mttid);
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
        mttid = ps.loadInt();
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
				result.append("TournamentUpdatePacket :");
        result.append((new StringBuilder()).append(" mttid[").append(mttid).append("]").toString());
        result.append((new StringBuilder()).append(" params[").append(params).append("]").toString());
        result.append((new StringBuilder()).append(" removed_params[").append(removedParams).append("]").toString());
        return result.toString();
    }

    public int mttid;
    public List params;
    public String removedParams[];
}