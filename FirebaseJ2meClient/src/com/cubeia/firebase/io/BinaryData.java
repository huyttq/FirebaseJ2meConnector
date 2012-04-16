// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:48:28 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   BinaryData.java

package com.cubeia.firebase.io;


public class BinaryData
{

    public BinaryData()
    {
    }

    public static int asUnsigned(byte value)
    {
        return value & 0xff;
    }

    public static int asUnsigned(short value)
    {
        return value & 0xffff;
    }

    public static long asUnsigned(int value)
    {
        return (long)(value & -1);
    }
}