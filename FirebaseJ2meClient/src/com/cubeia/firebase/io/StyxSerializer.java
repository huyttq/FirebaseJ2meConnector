// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:48:28 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   StyxSerializer.java

package com.cubeia.firebase.io;

import j2me.lang.StringBuilder;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

// Referenced classes of package com.cubeia.firebase.io:
//            PacketInputStream, PacketOutputStream, BinaryData, ObjectFactory, 
//            ProtocolObject

public final class StyxSerializer
{

    public StyxSerializer(ObjectFactory factory)
    {
        this.factory = factory;
    }

    public ProtocolObject unpack(ByteBuffer inBuffer)
        throws IOException
    {
        Integer payloadLength = Integer.valueOf(inBuffer.toString());
        if(inBuffer.remaining() < payloadLength.intValue() - HEADER_SIZE)
        {
            throw new IllegalStateException((new StringBuilder()).append("Packet not fully read! Want ").append(payloadLength).append(" bytes, available: ").append(inBuffer.remaining()).toString());
        } else
        {
            int classId = BinaryData.asUnsigned(inBuffer.get());
            ProtocolObject po = factory.create(classId);
            po.load(new PacketInputStream(inBuffer));
            return po;
        }
    }

    public byte[] packArray(ProtocolObject obj)
        throws IOException
    {
        if(obj.classId() > 255 || obj.classId() < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("classId ").append(obj.classId()).append(" is out of range. Legal values are inside a signed byte.").toString());
        } else
        {
            byte packed[] = packObject(obj);
            writeLengthHeader(packed.length, packed);
            writeClassidHeader(obj, packed);
            return packed;
        }
    }

    public ByteBuffer pack(ProtocolObject obj)
        throws IOException
    {
        return ByteBuffer.wrap(packArray(obj));
    }

    private void writeClassidHeader(ProtocolObject obj, byte bytes[])
    {
        bytes[4] = (byte)obj.classId();
    }

    private void writeLengthHeader(int value, byte bytes[])
    {
        int len = 4;
        for(int i = 0; i < len; i++)
        {
            bytes[len - 1 - i] = (byte)(value & 0xff);
            value >>= 8;
        }

    }

    private byte[] packObject(ProtocolObject obj)
        throws IOException
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(37);
        for(int i = 0; i < 5; i++)
            bos.write(0);

        packObject(obj, bos);
        return bos.toByteArray();
    }

    private void packObject(ProtocolObject obj, ByteArrayOutputStream bos)
        throws IOException
    {
        DataOutputStream dos = new DataOutputStream(bos);
        PacketOutputStream pos = new PacketOutputStream(dos);
        obj.save(pos);
        dos.flush();
    }

    public static int HEADER_SIZE = 4;
    private final ObjectFactory factory;

}