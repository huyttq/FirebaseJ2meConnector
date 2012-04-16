// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:13 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Attribute.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class Attribute
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 8;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public Attribute()
    {
    }

    public Attribute(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveString(name);
        ps.saveString(value);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        name = ps.loadString();
        value = ps.loadString();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("Attribute :");
        result.append((new StringBuilder()).append(" name[").append(name).append("]").toString());
        result.append((new StringBuilder()).append(" value[").append(value).append("]").toString());
        return result.toString();
    }

    public String name;
    public String value;
}