// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 4/16/2012 11:48:28 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   JsonContainer.java

package com.cubeia.firebase.io;


// Referenced classes of package com.cubeia.firebase.io:
//            ProtocolObject

public class JsonContainer
{

    public JsonContainer()
    {
    }

    public JsonContainer(ProtocolObject obj)
    {
        setData(obj);
    }

    public void setClassId(int classId)
    {
        this.classId = classId;
    }

    public void setData(ProtocolObject object)
    {
        data = object;
        if(data != null)
            classId = data.classId();
    }

    public int getClassId()
    {
        return classId;
    }

    public ProtocolObject getData()
    {
        return data;
    }

    private int classId;
    private ProtocolObject data;
}