package com.jmobilecore.comm;

import javax.microedition.io.HttpConnection;
import javax.microedition.io.Connector;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Enumeration;

public class HttpSimpleConnection {

    public HttpConnection http;
    public DataInputStream iStrm;
    public Hashtable httpProperties = new Hashtable(8);
    public int responseCode = HttpConnection.HTTP_OK;

    public HttpSimpleConnection() {
        init();
    }

    public HttpSimpleConnection(String connString) {
        init();
        open(connString);
    }

    protected void init() {
        http = null;
        iStrm = null;
        httpProperties.put("Content-Type", "application/x-www-form-urlencoded");
    }

    public boolean open(String connString) {
        boolean bRes = openHTTP(connString);
        if (!bRes) {
            closeHTTP();
        }
        return bRes;
    }

    public void close() {
        if (iStrm != null) closeInputStream();
        if (http != null) closeHTTP();
    }

    protected boolean openHTTP(String url) {
        try {
            http = (HttpConnection) Connector.open(url, Connector.READ_WRITE, true);
            http.setRequestMethod(HttpConnection.POST);
            for (Enumeration e=httpProperties.keys(); e.hasMoreElements();) {
                String key = (String) e.nextElement();
                String value = (String) httpProperties.get(key);
                http.setRequestProperty(key, value);
            }
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    protected void closeHTTP() {

        if (http != null) {
            try {
                http.close();
            } catch (Exception ignored) {
            }
            http = null;
        }
    }

    protected boolean openInputStream() {

        try {
            iStrm = http.openDataInputStream();
            responseCode = http.getResponseCode();
            if (responseCode != HttpConnection.HTTP_OK) {
                return false;
            }
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    protected void closeInputStream() {

        if (iStrm != null) {
            try {
                iStrm.close();
            } catch (Exception ignored) {
            }
            iStrm = null;
        }
    }

    public int readBytes(byte[] data, int len) throws IOException {
        if (iStrm == null) openInputStream();
        return iStrm.read(data, 0, len);
    }
}
