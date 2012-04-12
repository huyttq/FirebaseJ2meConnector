package com.jmobilecore.comm;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.IOException;

/**
 * The class is J2ME port of Sun's BufferedOutputStream which
 * implements a buffered output stream. By setting up such
 * an output stream, an application can write bytes to the underlying
 * output stream without necessarily causing a call to the underlying
 * system for each byte written.
 *
 * @author Greg Gridin
 */
public class BufferedOutputStream extends ByteArrayOutputStream {

    protected static int DEFAULT_BUFFER_SIZE = 512;

    /**
     * The output stream.
     */
    protected OutputStream out;

    /**
     * Creates a new buffered output stream to write data to the
     * specified underlying output stream with a default 512-byte
     * buffer size.
     *
     * @param out the underlying output stream.
     */
    public BufferedOutputStream(OutputStream out) {
        this(out, DEFAULT_BUFFER_SIZE);
    }

    /**
     * Creates a new buffered output stream to write data to the
     * specified underlying output stream with the specified buffer
     * size.
     *
     * @param out  the underlying output stream.
     * @param size the buffer size.
     * @throws IllegalArgumentException if size &lt;= 0.
     */
    public BufferedOutputStream(OutputStream out, int size) {
        super(size);
        reset();
        this.out = out;
    }

    /**
     * Flush the internal buffer
     */
    private void flushBuffer() throws IOException {
        if (count > 0) {
            out.write(toByteArray(), 0, count);
            reset();
        }
    }

    /**
     * Writes the specified byte to this buffered output stream.
     *
     * @param b the byte to be written.
     */
    public void write(int b) {
        if (count >= buf.length) {
            try {
                flushBuffer();
            } catch (IOException e) {
                throw new RuntimeIOException(e.getMessage());
            }
        }
        buf[count++] = (byte) b;
    }

    /**
     * Writes <code>len</code> bytes from the specified byte array
     * starting at offset <code>off</code> to this buffered output stream.
     * <p/>
     * <p> Ordinarily this method stores bytes from the given array into this
     * stream's buffer, flushing the buffer to the underlying output stream as
     * needed.  If the requested length is at least as large as this stream's
     * buffer, however, then this method will flush the buffer and write the
     * bytes directly to the underlying output stream.  Thus redundant
     * <code>BufferedOutputStream</code>s will not copy data unnecessarily.
     *
     * @param b   the data.
     * @param off the start offset in the data.
     * @param len the number of bytes to write.
     */
    public void write(byte b[], int off, int len) {
        if (len >= buf.length) {
            /* If the request length exceeds the size of the output buffer,
                   flush the output buffer and then write the data directly.
                   In this way buffered streams will cascade harmlessly. */
            try {
                flushBuffer();
                out.write(b, off, len);
            } catch (IOException e) {
                throw new RuntimeIOException(e.getMessage());
            }
            return;
        }
        if (len > buf.length - count) {
            try {
                flushBuffer();
            } catch (IOException e) {
                throw new RuntimeIOException(e.getMessage());
            }
        }
        System.arraycopy(b, off, buf, count, len);
        count += len;
    }

    /**
     * Flushes this buffered output stream. This forces any buffered
     * output bytes to be written out to the underlying output stream.
     *
     * @throws IOException if an I/O error occurs.
     */
    public void flush() throws IOException {
        flushBuffer();
        out.flush();
    }
}
