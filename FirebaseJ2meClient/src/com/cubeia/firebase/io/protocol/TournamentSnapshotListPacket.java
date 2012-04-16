// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:16 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TournamentSnapshotListPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, TournamentSnapshotPacket

public final class TournamentSnapshotListPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 155;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public TournamentSnapshotListPacket()
    {
    }

    public TournamentSnapshotListPacket(List snapshots)
    {
        this.snapshots = snapshots;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        if(snapshots == null)
        {
            ps.saveInt(0);
        } else
        {
            ps.saveInt(snapshots.size());
            for(int i = 0; i != snapshots.size(); i++)
                ((TournamentSnapshotPacket)snapshots.get(i)).save(ps);

        }
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        int snapshotsCount = ps.loadInt();
        snapshots = new ArrayList(snapshotsCount);
        for(int i = 0; i != snapshotsCount; i++)
        {
            TournamentSnapshotPacket _tmp = new TournamentSnapshotPacket();
            _tmp.load(ps);
            snapshots.add(_tmp);
        }

    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("TournamentSnapshotListPacket :");
        result.append((new StringBuilder()).append(" snapshots[").append(snapshots).append("]").toString());
        return result.toString();
    }

    public List snapshots;
}