// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:48:28 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ObjectFactory.java

package com.cubeia.firebase.io;


// Referenced classes of package com.cubeia.firebase.io:
//            ProtocolObject

public interface ObjectFactory
{

    public abstract int version();

    public abstract ProtocolObject create(int i);
}