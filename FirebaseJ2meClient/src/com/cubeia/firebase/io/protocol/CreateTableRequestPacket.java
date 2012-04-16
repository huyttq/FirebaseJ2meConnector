// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:13 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   CreateTableRequestPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Param

public final class CreateTableRequestPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 40;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public CreateTableRequestPacket()
    {
        invitees = new int[0];
    }

    public CreateTableRequestPacket(int seq, int gameid, byte seats, List params, int invitees[])
    {
        this.invitees = new int[0];
        this.seq = seq;
        this.gameid = gameid;
        this.seats = seats;
        this.params = params;
        this.invitees = invitees;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(seq);
        ps.saveInt(gameid);
        ps.saveByte(seats);
        if(params == null)
        {
            ps.saveInt(0);
        } else
        {
            ps.saveInt(params.size());
            for(int i = 0; i != params.size(); i++)
                ((Param)params.get(i)).save(ps);

        }
        ps.saveInt(invitees.length);
        ps.saveArray(invitees);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        seq = ps.loadInt();
        gameid = ps.loadInt();
        seats = ps.loadByte();
        int paramsCount = ps.loadInt();
        params = new ArrayList(paramsCount);
        for(int i = 0; i != paramsCount; i++)
        {
            Param _tmp = new Param();
            _tmp.load(ps);
            params.add(_tmp);
        }

        int inviteesCount = ps.loadInt();
        invitees = new int[inviteesCount];
        ps.loadIntArray(invitees);
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("CreateTableRequestPacket :");
        result.append((new StringBuilder()).append(" seq[").append(seq).append("]").toString());
        result.append((new StringBuilder()).append(" gameid[").append(gameid).append("]").toString());
        result.append((new StringBuilder()).append(" seats[").append(seats).append("]").toString());
        result.append((new StringBuilder()).append(" params[").append(params).append("]").toString());
        result.append((new StringBuilder()).append(" invitees[").append(invitees).append("]").toString());
        return result.toString();
    }

    public int seq;
    public int gameid;
    public byte seats;
    public List params;
    public int invitees[];
}