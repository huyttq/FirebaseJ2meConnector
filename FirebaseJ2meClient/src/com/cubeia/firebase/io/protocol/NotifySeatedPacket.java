// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:15 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   NotifySeatedPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, TableSnapshotPacket

public final class NotifySeatedPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 62;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public NotifySeatedPacket()
    {
    }

    public NotifySeatedPacket(int tableid, byte seat, int mttid, TableSnapshotPacket snapshot)
    {
        this.tableid = tableid;
        this.seat = seat;
        this.mttid = mttid;
        this.snapshot = snapshot;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(tableid);
        ps.saveByte(seat);
        ps.saveInt(mttid);
        snapshot.save(ps);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        tableid = ps.loadInt();
        seat = ps.loadByte();
        mttid = ps.loadInt();
        snapshot = new TableSnapshotPacket();
        snapshot.load(ps);
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("NotifySeatedPacket :");
        result.append((new StringBuilder()).append(" tableid[").append(tableid).append("]").toString());
        result.append((new StringBuilder()).append(" seat[").append(seat).append("]").toString());
        result.append((new StringBuilder()).append(" mttid[").append(mttid).append("]").toString());
        result.append((new StringBuilder()).append(" snapshot[").append(snapshot).append("]").toString());
        return result.toString();
    }

    public int tableid;
    public byte seat;
    public int mttid;
    public TableSnapshotPacket snapshot;
}