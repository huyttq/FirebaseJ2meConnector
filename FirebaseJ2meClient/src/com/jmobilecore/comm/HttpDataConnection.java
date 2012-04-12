package com.jmobilecore.comm;

import javax.microedition.io.HttpConnection;
import javax.microedition.io.Connector;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Enumeration;

public class HttpDataConnection {

    public HttpConnection http;
    public DataOutputStream oStrm;
    public DataInputStream iStrm;
    public Hashtable httpProperties = new Hashtable(8);
    public int responseCode = HttpConnection.HTTP_OK;

    public HttpDataConnection() {
        init();
    }

    public HttpDataConnection(String connString) {
        init();
        open(connString);
    }

    protected void init() {
        http = null;
        oStrm = null;
        iStrm = null;
        httpProperties.put("Content-Type", "application/x-www-form-urlencoded");
    }

    public boolean open(String connString) {

        if (openHTTP(connString)) {
            if (openOutputStream()) {
                return true;
            }
        }
        close();
        return false;
    }

    public void close() {
        if (iStrm != null) closeInputStream();
        if (oStrm != null) closeOutputStream();
        if (http != null) closeHTTP();
    }

    protected boolean openHTTP(String connString) {
        try {
            http = (HttpConnection) Connector.open(connString, Connector.READ_WRITE, true);
            http.setRequestMethod(HttpConnection.POST);
            for (Enumeration e=httpProperties.keys(); e.hasMoreElements();) {
                String key = (String) e.nextElement();
                String value = (String) httpProperties.get(key);
                http.setRequestProperty(key, value);
            }
        } catch (Exception ignored) {
            return false;
        }
        return true;
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

    protected boolean openOutputStream() {

        try {
            oStrm = http.openDataOutputStream();
        } catch (Exception ignored) {
            return false;
        }
        return oStrm != null;
    }

    protected void closeOutputStream() {

        if (oStrm != null) {
            try {
                oStrm.close();
            } catch (Exception ignored) {
            }
            oStrm = null;
        }
    }

    public boolean openInputStream() {

        try {
            iStrm = http.openDataInputStream();
            responseCode = http.getResponseCode();
            if (responseCode != HttpConnection.HTTP_OK) {
                return false;
            }
        } catch (Exception ignored) {
            return false;
        }
        return iStrm != null;
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

    public boolean post(byte[] data) {

        if (oStrm != null) {
            try {
                oStrm.write(data, 0, data.length);
            } catch (Exception ignored) {
                return false;
            }
        }
        return true;
    }

    public boolean post(String data) {

        if (oStrm != null) {
            try {
                oStrm.writeUTF(data);
            } catch (Exception ignored) {
                return false;
            }
        }
        return true;
    }

    public boolean post(int data) {

        if (oStrm != null) {
            try {
                oStrm.writeInt(data);
            } catch (Exception ignored) {
                return false;
            }
        }
        return true;
    }

    public boolean post(boolean data) {

        if (oStrm != null) {
            try {
                oStrm.writeBoolean(data);
            } catch (Exception ignored) {
                return false;
            }
        }
        return true;
    }

    public boolean flush() {

        try {
            oStrm.flush();
        } catch (Exception ignored) {
            return false;
        }
        return true;
    }

    public int readBytes(byte[] data, int len) throws IOException {
        if (iStrm == null) openInputStream();
        return iStrm.read(data, 0, len);
    }

    public boolean readBoolean() throws IOException {
        if (iStrm == null) openInputStream();
        return iStrm.readBoolean();
    }

    public byte readByte() throws IOException {
        if (iStrm == null) openInputStream();
        return (iStrm.readByte());
    }

    public short readShort() throws IOException {
        if (iStrm == null) openInputStream();
        return (iStrm.readShort());
    }

    public char readChar() throws IOException {
        if (iStrm == null) openInputStream();
        return (iStrm.readChar());
    }

    public int readInt() throws IOException {
        if (iStrm == null) openInputStream();
        return (iStrm.readInt());
    }

    public long readLong() throws IOException {
        if (iStrm == null) openInputStream();
        return (iStrm.readLong());
    }

    public String readString() throws IOException {
        if (iStrm == null) openInputStream();
        return iStrm.readUTF();
    }

}
