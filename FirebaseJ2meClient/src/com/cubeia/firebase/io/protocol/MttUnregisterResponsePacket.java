// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:15 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   MttUnregisterResponsePacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Enums

public final class MttUnregisterResponsePacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 208;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public MttUnregisterResponsePacket()
    {
        status = Enums.makeTournamentRegisterResponseStatus(0);
    }

    public MttUnregisterResponsePacket(int mttid, Enums.TournamentRegisterResponseStatus status)
    {
        this.status = Enums.makeTournamentRegisterResponseStatus(0);
        this.mttid = mttid;
        this.status = status;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(mttid);
        ps.saveUnsignedByte(status.ordinal());
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        mttid = ps.loadInt();
        status = Enums.makeTournamentRegisterResponseStatus(ps.loadUnsignedByte());
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("MttUnregisterResponsePacket :");
        result.append((new StringBuilder()).append(" mttid[").append(mttid).append("]").toString());
        result.append((new StringBuilder()).append(" status[").append(status).append("]").toString());
        return result.toString();
    }

    public int mttid;
    public Enums.TournamentRegisterResponseStatus status;
}