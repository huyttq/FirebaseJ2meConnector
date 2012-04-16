// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:15 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ParamFilter.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Param

public final class ParamFilter
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 6;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public ParamFilter()
    {
    }

    public ParamFilter(Param param, byte op)
    {
        this.param = param;
        this.op = op;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        param.save(ps);
        ps.saveByte(op);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        param = new Param();
        param.load(ps);
        op = ps.loadByte();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("ParamFilter :");
        result.append((new StringBuilder()).append(" param[").append(param).append("]").toString());
        result.append((new StringBuilder()).append(" op[").append(op).append("]").toString());
        return result.toString();
    }

    public Param param;
    public byte op;
}