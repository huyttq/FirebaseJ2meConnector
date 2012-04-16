// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:14 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   GameTransportPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import com.cubeia.firebase.styx.util.ArrayUtils;
import j2me.lang.StringBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Attribute

public final class GameTransportPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 100;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public GameTransportPacket()
    {
        gamedata = new byte[0];
    }

    public GameTransportPacket(int tableid, int pid, byte gamedata[], List attributes)
    {
        this.gamedata = new byte[0];
        this.tableid = tableid;
        this.pid = pid;
        this.gamedata = gamedata;
        this.attributes = attributes;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveInt(tableid);
        ps.saveInt(pid);
        ps.saveInt(gamedata.length);
        ps.saveArray(gamedata);
        if(attributes == null)
        {
            ps.saveInt(0);
        } else
        {
            ps.saveInt(attributes.size());
            for(int i = 0; i != attributes.size(); i++)
                ((Attribute)attributes.get(i)).save(ps);

        }
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        tableid = ps.loadInt();
        pid = ps.loadInt();
        int gamedataCount = ps.loadInt();
        gamedata = new byte[gamedataCount];
        ps.loadByteArray(gamedata);
        int attributesCount = ps.loadInt();
        attributes = new ArrayList(attributesCount);
        for(int i = 0; i != attributesCount; i++)
        {
            Attribute _tmp = new Attribute();
            _tmp.load(ps);
            attributes.add(_tmp);
        }

    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("GameTransportPacket :");
        result.append((new StringBuilder()).append(" tableid[").append(tableid).append("]").toString());
        result.append((new StringBuilder()).append(" pid[").append(pid).append("]").toString());
        result.append((new StringBuilder()).append(" gamedata[").append(ArrayUtils.toString(gamedata, 20)).append("]").toString());
        result.append((new StringBuilder()).append(" attributes[").append(attributes).append("]").toString());
        return result.toString();
    }

    public int tableid;
    public int pid;
    public byte gamedata[];
    public List attributes;
}