// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:48:28 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ProtocolObject.java

package com.cubeia.firebase.io;

import java.io.IOException;

// Referenced classes of package com.cubeia.firebase.io:
//            Visitable, PacketOutputStream, PacketInputStream

public interface ProtocolObject
    extends Visitable
{

    public abstract int classId();

    public abstract void save(PacketOutputStream packetoutputstream)
        throws IOException;

    public abstract void load(PacketInputStream packetinputstream)
        throws IOException;
}