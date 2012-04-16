// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:13 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   EncryptedTransportPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import com.cubeia.firebase.styx.util.ArrayUtils;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class EncryptedTransportPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 105;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public EncryptedTransportPacket()
    {
        payload = new byte[0];
    }

    public EncryptedTransportPacket(byte func, byte payload[])
    {
        this.payload = new byte[0];
        this.func = func;
        this.payload = payload;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveByte(func);
        ps.saveInt(payload.length);
        ps.saveArray(payload);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        func = ps.loadByte();
        int payloadCount = ps.loadInt();
        payload = new byte[payloadCount];
        ps.loadByteArray(payload);
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("EncryptedTransportPacket :");
        result.append((new StringBuilder()).append(" func[").append(func).append("]").toString());
        result.append((new StringBuilder()).append(" payload[").append(ArrayUtils.toString(payload, 20)).append("]").toString());
        return result.toString();
    }

    public byte func;
    public byte payload[];
}