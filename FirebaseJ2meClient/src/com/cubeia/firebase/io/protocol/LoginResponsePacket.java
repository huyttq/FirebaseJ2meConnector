// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:15 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   LoginResponsePacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import com.cubeia.firebase.styx.util.ArrayUtils;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor, Enums

public final class LoginResponsePacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 11;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public LoginResponsePacket()
    {
        status = Enums.makeResponseStatus(0);
        credentials = new byte[0];
    }

    public LoginResponsePacket(String screenname, int pid, Enums.ResponseStatus status, int code, String message, byte credentials[])
    {
        this.status = Enums.makeResponseStatus(0);
        this.credentials = new byte[0];
        this.screenname = screenname;
        this.pid = pid;
        this.status = status;
        this.code = code;
        this.message = message;
        this.credentials = credentials;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveString(screenname);
        ps.saveInt(pid);
        ps.saveUnsignedByte(status.ordinal());
        ps.saveInt(code);
        ps.saveString(message);
        ps.saveInt(credentials.length);
        ps.saveArray(credentials);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        screenname = ps.loadString();
        pid = ps.loadInt();
        status = Enums.makeResponseStatus(ps.loadUnsignedByte());
        code = ps.loadInt();
        message = ps.loadString();
        int credentialsCount = ps.loadInt();
        credentials = new byte[credentialsCount];
        ps.loadByteArray(credentials);
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("LoginResponsePacket :");
        result.append((new StringBuilder()).append(" screenname[").append(screenname).append("]").toString());
        result.append((new StringBuilder()).append(" pid[").append(pid).append("]").toString());
        result.append((new StringBuilder()).append(" status[").append(status).append("]").toString());
        result.append((new StringBuilder()).append(" code[").append(code).append("]").toString());
        result.append((new StringBuilder()).append(" message[").append(message).append("]").toString());
        result.append((new StringBuilder()).append(" credentials[").append(ArrayUtils.toString(credentials, 20)).append("]").toString());
        return result.toString();
    }

    public String screenname;
    public int pid;
    public Enums.ResponseStatus status;
    public int code;
    public String message;
    public byte credentials[];
}