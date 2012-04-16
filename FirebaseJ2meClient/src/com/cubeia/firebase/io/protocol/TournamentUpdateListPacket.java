// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:17 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TournamentUpdateListPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, TournamentUpdatePacket

public final class TournamentUpdateListPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 156;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public TournamentUpdateListPacket()
    {
    }

    public TournamentUpdateListPacket(List updates)
    {
        this.updates = updates;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        if(updates == null)
        {
            ps.saveInt(0);
        } else
        {
            ps.saveInt(updates.size());
            for(int i = 0; i != updates.size(); i++)
                ((TournamentUpdatePacket)updates.get(i)).save(ps);

        }
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        int updatesCount = ps.loadInt();
        updates = new ArrayList(updatesCount);
        for(int i = 0; i != updatesCount; i++)
        {
            TournamentUpdatePacket _tmp = new TournamentUpdatePacket();
            _tmp.load(ps);
            updates.add(_tmp);
        }

    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("TournamentUpdateListPacket :");
        result.append((new StringBuilder()).append(" updates[").append(updates).append("]").toString());
        return result.toString();
    }

    public List updates;
}