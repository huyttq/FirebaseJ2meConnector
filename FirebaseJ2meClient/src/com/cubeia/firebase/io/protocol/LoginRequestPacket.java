// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:58:15 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   LoginRequestPacket.java

package com.cubeia.firebase.io.protocol;

import com.cubeia.firebase.io.*;
import com.cubeia.firebase.styx.util.ArrayUtils;
import j2me.lang.StringBuilder;
import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io.protocol:
//            PacketVisitor

public final class LoginRequestPacket
    implements ProtocolObject, Visitable
{

    public int classId()
    {
        return 10;
    }

    public void accept(ProtocolObjectVisitor visitor)
    {
        if(visitor instanceof PacketVisitor)
        {
            PacketVisitor handler = (PacketVisitor)visitor;
            handler.visit(this);
        }
    }

    public LoginRequestPacket()
    {
        credentials = new byte[0];
    }

    public LoginRequestPacket(String user, String password, int operatorid, byte credentials[])
    {
        this.credentials = new byte[0];
        this.user = user;
        this.password = password;
        this.operatorid = operatorid;
        this.credentials = credentials;
    }

    public void save(PacketOutputStream ps)
        throws IOException
    {
        ps.saveString(user);
        ps.saveString(password);
        ps.saveInt(operatorid);
        ps.saveInt(credentials.length);
        ps.saveArray(credentials);
    }

    public void load(PacketInputStream ps)
        throws IOException
    {
        user = ps.loadString();
        password = ps.loadString();
        operatorid = ps.loadInt();
        int credentialsCount = ps.loadInt();
        credentials = new byte[credentialsCount];
        ps.loadByteArray(credentials);
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
				result.append("LoginRequestPacket :");
        result.append((new StringBuilder()).append(" user[").append(user).append("]").toString());
        result.append((new StringBuilder()).append(" password[").append(password).append("]").toString());
        result.append((new StringBuilder()).append(" operatorid[").append(operatorid).append("]").toString());
        result.append((new StringBuilder()).append(" credentials[").append(ArrayUtils.toString(credentials, 20)).append("]").toString());
        return result.toString();
    }

    public String user;
    public String password;
    public int operatorid;
    public byte credentials[];
}