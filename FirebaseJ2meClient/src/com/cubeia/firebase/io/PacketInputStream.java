// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:48:28 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   PacketInputStream.java

package com.cubeia.firebase.io;

import java.io.IOException;
import java.nio.ByteBuffer;

// Referenced classes of package com.cubeia.firebase.io:
//            BinaryData

public final class PacketInputStream
{

    public PacketInputStream(ByteBuffer inBuffer)
    {
        this.inBuffer = inBuffer;
    }

    public byte loadByte()
        throws IOException
    {
        return inBuffer.get();
    }

    public int loadUnsignedByte()
        throws IOException
    {
        return BinaryData.asUnsigned(inBuffer.get());
    }

    public int loadUnsignedShort()
        throws IOException
    {
        return BinaryData.asUnsigned(inBuffer.getShort());
    }

    public short loadShort()
        throws IOException
    {
        return inBuffer.getShort();
    }

    public int loadInt()
        throws IOException
    {
        return inBuffer.getInt();
    }

    public long loadUnsignedInt()
    {
        long uint = 0L;
        uint |= inBuffer.get() << 24;
        uint |= inBuffer.get() << 16;
        uint |= inBuffer.get() << 8;
        uint |= inBuffer.get();
        return uint;
    }

    /*public long loadLong()
        throws IOException
    {
        return inBuffer. .getLong();
    }*/

    public boolean loadBoolean()
        throws IOException
    {
        return inBuffer.get() != 0;
    }

    public String loadString()
        throws IOException
    {
        int length = 0xffff & inBuffer.getShort();
        byte utf8[] = new byte[length];
        inBuffer.get(utf8);
        return new String(utf8, "UTF-8");
    }

    public void loadByteArray(byte arg0[])
        throws IOException
    {
        inBuffer.get(arg0);
    }

    public void loadIntArray(int data[])
        throws IOException
    {
        for(int i = 0; i < data.length; i++)
            data[i] = inBuffer.getInt();

    }

    public void loadStringArray(String removedParams[])
        throws IOException
    {
        for(int i = 0; i < removedParams.length; i++)
            removedParams[i] = loadString();

    }

    private final ByteBuffer inBuffer;

	public long loadLong() {
			throw new UnsupportedOperationException("Not yet implemented");
	}
}