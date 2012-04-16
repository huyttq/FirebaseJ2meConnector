// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:14 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   InvitePlayersRequestPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class InvitePlayersRequestPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 42;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public InvitePlayersRequestPacket()
    {
        invitees = new int[0];
    }

    public InvitePlayersRequestPacket(int tableid, int invitees[])
    {
        this.invitees = new int[0];
        this.tableid = tableid;
        this.invitees = invitees;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(tableid);
        ps.saveInt(invitees.length);
        ps.saveArray(invitees);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        tableid = ps.loadInt();
        int inviteesCount = ps.loadInt();
        invitees = new int[inviteesCount];
        ps.loadIntArray(invitees);
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("InvitePlayersRequestPacket :");
        result.append((new StringBuilder()).append(" tableid[").append(tableid).append("]").toString());
        result.append((new StringBuilder()).append(" invitees[").append(invitees).append("]").toString());
        return result.toString();
    }

    public int tableid;
    public int invitees[];
}