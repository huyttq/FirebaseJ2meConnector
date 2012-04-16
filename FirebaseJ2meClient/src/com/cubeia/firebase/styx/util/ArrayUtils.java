// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:48:29 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ArrayUtils.java

package com.cubeia.firebase.styx.util;

import j2me.lang.StringBuilder;


public class ArrayUtils
{

    public ArrayUtils()
    {
    }

    public static String toString(byte array[], int maxPrintSize)
    {
        if(array == null)
            return "null";
        if(array.length == 0)
            return "{}";
        StringBuilder s = new StringBuilder();
        s.append("{");
        s.append(array[0]);
        for(int i = 1; i < Math.min(array.length, maxPrintSize); i++)
            s.append(", ").append(array[i]);

        if(array.length > maxPrintSize)
            s.append((new StringBuilder()).append("... (").append(array.length).toString()).append(")");
        s.append("}");
        return s.toString();
    }
}