// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:16 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   SystemInfoRequestPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class SystemInfoRequestPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 18;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public SystemInfoRequestPacket()
    {
    }

    public void save(PacketOutputStream packetoutputstream)
        throws IOException
    {
    }

    public void load(PacketInputStream packetinputstream)
        throws IOException
    {
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("SystemInfoRequestPacket :");
        return result.toString();
    }
}