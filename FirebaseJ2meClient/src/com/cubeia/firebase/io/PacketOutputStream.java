// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:48:28 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   PacketOutputStream.java

package com.cubeia.firebase.io;

import j2me.lang.StringBuilder;
import java.io.DataOutputStream;
import java.io.IOException;

public final class PacketOutputStream
{

    public PacketOutputStream(DataOutputStream os)
    {
        this.os = os;
    }

    public void saveByte(byte val)
        throws IOException
    {
        os.writeByte(val);
    }

    public void saveUnsignedByte(int val)
        throws IOException
    {
        os.writeByte(val);
    }

    public void saveUnsignedShort(int val)
        throws IOException
    {
        os.writeShort(val);
    }

    public void saveShort(short val)
        throws IOException
    {
        os.writeShort(val);
    }

    public void saveInt(int val)
        throws IOException
    {
        os.writeInt(val);
    }

    public void saveUnsignedInt(long val)
        throws IOException
    {
        os.write((byte)(int)(255L & val >>> 24));
        os.write((byte)(int)(255L & val >>> 16));
        os.write((byte)(int)(255L & val >>> 8));
        os.write((byte)(int)(255L & val));
    }

    public void saveLong(long val)
        throws IOException
    {
        os.writeLong(val);
    }

    public void saveBoolean(boolean val)
        throws IOException
    {
        os.writeByte(val ? 1 : 0);
    }

    public void saveString(String val)
        throws IOException
    {
        if(val == null)
            val = "";
        byte utf8[] = val.getBytes("UTF-8");
        if(utf8.length > 65535)
        {
            throw new IOException((new StringBuilder()).append("String byte length is too long: bytes = ").append(utf8.length).append(", max allowed = ").append(65535).toString());
        } else
        {
            os.writeShort(utf8.length);
            os.write(utf8, 0, utf8.length);
            return;
        }
    }

    public void saveArray(byte gamedata[])
        throws IOException
    {
        os.write(gamedata);
    }

    public void saveArray(int data[])
        throws IOException
    {
        int arr$[] = data;
        int len$ = arr$.length;
        for(int i$ = 0; i$ < len$; i$++)
        {
            int val = arr$[i$];
            os.writeInt(val);
        }

    }

    public void saveArray(String removedParams[])
        throws IOException
    {
        String arr$[] = removedParams;
        int len$ = arr$.length;
        for(int i$ = 0; i$ < len$; i$++)
        {
            String name = arr$[i$];
            saveString(name);
        }

    }

    public static final int STRING_MAX_BYTES = 65535;
    private DataOutputStream os;
}