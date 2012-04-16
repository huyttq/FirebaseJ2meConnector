// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:16 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TableSnapshotListPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, TableSnapshotPacket

public final class TableSnapshotListPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 153;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public TableSnapshotListPacket()
    {
    }

    public TableSnapshotListPacket(List snapshots)
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
                ((TableSnapshotPacket)snapshots.get(i)).save(ps);

        }
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        int snapshotsCount = ps.loadInt();
        snapshots = new ArrayList(snapshotsCount);
        for(int i = 0; i != snapshotsCount; i++)
        {
            TableSnapshotPacket _tmp = new TableSnapshotPacket();
            _tmp.load(ps);
            snapshots.add(_tmp);
        }

    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("TableSnapshotListPacket :");
        result.append((new StringBuilder()).append(" snapshots[").append(snapshots).append("]").toString());
        return result.toString();
    }

    public List snapshots;
}