// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:14 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   LobbyQueryPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Enums

public final class LobbyQueryPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 142;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public LobbyQueryPacket()
    {
        type = Enums.makeLobbyType(0);
    }

    public LobbyQueryPacket(int gameid, String address, Enums.LobbyType type)
    {
        this.type = Enums.makeLobbyType(0);
        this.gameid = gameid;
        this.address = address;
        this.type = type;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(gameid);
        ps.saveString(address);
        ps.saveUnsignedByte(type.ordinal());
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        gameid = ps.loadInt();
        address = ps.loadString();
        type = Enums.makeLobbyType(ps.loadUnsignedByte());
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("LobbyQueryPacket :");
        result.append((new StringBuilder()).append(" gameid[").append(gameid).append("]").toString());
        result.append((new StringBuilder()).append(" address[").append(address).append("]").toString());
        result.append((new StringBuilder()).append(" type[").append(type).append("]").toString());
        return result.toString();
    }

    public int gameid;
    public String address;
    public Enums.LobbyType type;
}