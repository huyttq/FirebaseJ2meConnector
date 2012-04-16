// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:14 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   LobbyObjectUnsubscribePacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Enums

public final class LobbyObjectUnsubscribePacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 152;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public LobbyObjectUnsubscribePacket()
    {
        type = Enums.makeLobbyType(0);
    }

    public LobbyObjectUnsubscribePacket(Enums.LobbyType type, int gameid, String address, int objectid)
    {
        this.type = Enums.makeLobbyType(0);
        this.type = type;
        this.gameid = gameid;
        this.address = address;
        this.objectid = objectid;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveUnsignedByte(type.ordinal());
        ps.saveInt(gameid);
        ps.saveString(address);
        ps.saveInt(objectid);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        type = Enums.makeLobbyType(ps.loadUnsignedByte());
        gameid = ps.loadInt();
        address = ps.loadString();
        objectid = ps.loadInt();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("LobbyObjectUnsubscribePacket :");
        result.append((new StringBuilder()).append(" type[").append(type).append("]").toString());
        result.append((new StringBuilder()).append(" gameid[").append(gameid).append("]").toString());
        result.append((new StringBuilder()).append(" address[").append(address).append("]").toString());
        result.append((new StringBuilder()).append(" objectid[").append(objectid).append("]").toString());
        return result.toString();
    }

    public Enums.LobbyType type;
    public int gameid;
    public String address;
    public int objectid;
}