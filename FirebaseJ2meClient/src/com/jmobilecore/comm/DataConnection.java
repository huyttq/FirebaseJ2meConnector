package com.jmobilecore.comm;

import javax.microedition.io.InputConnection;
import javax.microedition.io.OutputConnection;
import java.io.*;

public class DataConnection {

    public DataInputStream iStrm;
    public DataOutputStream oStrm;

    public DataConnection() {
    }

    public DataInputStream openDataInputStream(InputConnection inputConn) throws IOException {

        return openDataInputStream(inputConn.openInputStream());
    }

    public DataOutputStream openDataOutputStream(OutputConnection outputConn) throws IOException {

        return openDataOutputStream(outputConn.openOutputStream());
    }

    public DataInputStream openDataInputStream(InputStream inputStream) throws IOException {

        return iStrm = new DataInputStream(inputStream);
    }

    public DataOutputStream openDataOutputStream(OutputStream outputStream) throws IOException {

        return oStrm = new DataOutputStream(outputStream);
    }

    public void close() {

        closeInputStream();
        closeOutputStream();
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

    protected void closeOutputStream() {
        if (oStrm != null) {
            try {
                oStrm.close();
            } catch (Exception ignored) {
            }
            oStrm = null;
        }
    }
}
