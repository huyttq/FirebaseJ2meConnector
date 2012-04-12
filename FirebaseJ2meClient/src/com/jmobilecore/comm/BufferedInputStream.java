package com.jmobilecore.comm;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * The class is J2ME port of Sun's BufferedOutputStream which
 * implements a buffered input stream. When the <code>BufferedInputStream</code>
 * is created, an internal buffer array is created. As bytes  from the stream are read
 * or skipped, the internal buffer is refilled as necessary  from the contained input stream,
 * many bytes at a time.
 *
 * @author  Greg Gridin
 */
public class BufferedInputStream extends ByteArrayInputStream {

    protected static int DEFAULT_BUFFER_SIZE = 1024;

    /**
     * The input stream.
     */
    protected InputStream in;

    /**
     * The maximum read ahead allowed after a call to the
     * <code>mark</code> method before subsequent calls to the
     * <code>reset</code> method fail.
     * Whenever the difference between <code>pos</code>
     * and <code>markpos</code> exceeds <code>marklimit</code>,
     * then the  mark may be dropped by setting
     * <code>markpos</code> to <code>-1</code>.
     *
     * @see com.jmobilecore.comm.BufferedInputStream#mark(int)
     * @see com.jmobilecore.comm.BufferedInputStream#reset()
     */
    protected int marklimit;

    /**
     * Creates a <code>BufferedInputStream</code>
     * and saves its  argument, the input stream
     * <code>in</code>, for later use. An internal
     * buffer array is created and  stored in <code>buf</code>.
     *
     * @param in the underlying input stream.
     */
    public BufferedInputStream(InputStream in) {
        this(in, DEFAULT_BUFFER_SIZE);
    }

    /**
     * Creates a <code>BufferedInputStream</code>
     * with the specified buffer size,
     * and saves its  argument, the input stream
     * <code>in</code>, for later use.  An internal
     * buffer array of length  <code>size</code>
     * is created and stored in <code>buf</code>.
     *
     * @param in   the underlying input stream.
     * @param size the buffer size.
     * @throws IllegalArgumentException if size <= 0.
     */
    public BufferedInputStream(InputStream in, int size) {
        super(new byte[size]);
        count = 0;
        this.in = in;
    }

    /**
     * Fills the buffer with more data, taking into account
     * shuffling and other tricks for dealing with marks.
     * Assumes that it is being called by a synchronized method.
     * This method also assumes that all data has already been read in,
     * hence pos > count.
     */
    private void fill() throws IOException {
        if (mark < 0) {
            pos = 0;		/* no mark: throw away the buffer */
        } else if (pos >= buf.length) { /* no room left in buffer */
            if (mark > 0) {	/* can throw away early part of the buffer */
                int sz = pos - mark;
                System.arraycopy(buf, mark, buf, 0, sz);
                pos = sz;
                mark = 0;
            } else if (buf.length >= marklimit) {
                mark = -1;	/* buffer got too big, invalidate mark */
                pos = 0;	/* drop buffer contents */
            } else {		/* grow buffer */
                int nsz = pos * 2;
                if (nsz > marklimit)
                    nsz = marklimit;
                byte nbuf[] = new byte[nsz];
                System.arraycopy(buf, 0, nbuf, 0, pos);
                buf = nbuf;
            }
        }
        count = pos;
        int n = in.read(buf, pos, buf.length - pos);
        if (n > 0)
            count = n + pos;
    }

    /**
     * See
     * the general contract of the <code>read</code>
     * method of <code>InputStream</code>.
     *
     * @return the next byte of data, or <code>-1</code> if the end of the
     *         stream is reached.
     * @see com.jmobilecore.comm.BufferedInputStream#in
     */
    public int read() {
        if (pos >= count) {
            try {
                fill();
            } catch (IOException e) {
                return -1;
            }
            if (pos >= count)
                return -1;
        }
        return buf[pos++] & 0xff;
    }

    /**
     * Read characters into a portion of an array, reading from the underlying
     * stream at most once if necessary.
     */
    private int read1(byte[] b, int off, int len) throws IOException {
        int avail = count - pos;
        if (avail <= 0) {
            /* If the requested length is at least as large as the buffer, and
               if there is no mark/reset activity, do not bother to copy the
               bytes into the local buffer.  In this way buffered streams will
               cascade harmlessly. */
            if (len >= buf.length && mark < 0) {
                return in.read(b, off, len);
            }
            fill();
            avail = count - pos;
            if (avail <= 0) return -1;
        }
        int cnt = (avail < len) ? avail : len;
        System.arraycopy(buf, pos, b, off, cnt);
        pos += cnt;
        return cnt;
    }

    /**
     * Reads bytes from this byte-input stream into the specified byte array,
     * starting at the given offset.
     * <p/>
     * <p> This method implements the general contract of the corresponding
     * <code>{@link InputStream#read(byte[], int, int) read}</code> method of
     * the <code>{@link InputStream}</code> class.  As an additional
     * convenience, it attempts to read as many bytes as possible by repeatedly
     * invoking the <code>read</code> method of the underlying stream.  This
     * iterated <code>read</code> continues until one of the following
     * conditions becomes true: <ul>
     * <p/>
     * <li> The specified number of bytes have been read,
     * <p/>
     * <li> The <code>read</code> method of the underlying stream returns
     * <code>-1</code>, indicating end-of-file, or
     * <p/>
     * <li> The <code>available</code> method of the underlying stream
     * returns zero, indicating that further input requests would block.
     * <p/>
     * </ul> If the first <code>read</code> on the underlying stream returns
     * <code>-1</code> to indicate end-of-file then this method returns
     * <code>-1</code>.  Otherwise this method returns the number of bytes
     * actually read.
     * <p/>
     * <p> Subclasses of this class are encouraged, but not required, to
     * attempt to read as many bytes as possible in the same fashion.
     *
     * @param b   destination buffer.
     * @param off offset at which to start storing bytes.
     * @param len maximum number of bytes to read.
     * @return the number of bytes read, or <code>-1</code> if the end of
     *         the stream has been reached.
     */
    public int read(byte b[], int off, int len) {
        if ((off | len | (off + len) | (b.length - (off + len))) < 0) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return 0;
        }
        try {
            int n = read1(b, off, len);
            if (n <= 0) return n;
            while ((n < len) && (in.available() > 0)) {
                int n1 = read1(b, off + n, len - n);
                if (n1 <= 0) break;
                n += n1;
            }
            return n;
        } catch (IOException e) {
            return -1;
        }
    }

    /**
     * See the general contract of the <code>skip</code>
     * method of <code>InputStream</code>.
     *
     * @param n the number of bytes to be skipped.
     * @return the actual number of bytes skipped.
     */
    public long skip(long n) {
        if (n <= 0) {
            return 0;
        }
        long avail = count - pos;

        if (avail <= 0) {
            // If no mark position set then don't keep in buffer
            if (mark < 0)
                try {
                    return in.skip(n);
                } catch (IOException e) {
                    return -1;
                }

            // Fill in buffer to save bytes for reset
            try {
                fill();
            } catch (IOException e) {
                return -1;
            }
            avail = count - pos;
            if (avail <= 0)
                return 0;
        }

        long skipped = (avail < n) ? avail : n;
        pos += skipped;
        return skipped;
    }

    /**
     * Returns the number of bytes that can be read from this input
     * stream without blocking.
     * <p/>
     * The <code>available</code> method of
     * <code>BufferedInputStream</code> returns the sum of the the number
     * of bytes remaining to be read in the buffer
     * (<code>count&nbsp;- pos</code>)
     * and the result of calling the <code>available</code> method of the
     * underlying input stream.
     *
     * @return the number of bytes that can be read from this input
     *         stream without blocking.
     * @see com.jmobilecore.comm.BufferedInputStream#in
     */
    public int available() {
        try {
            return (count - pos) + in.available();
        } catch (IOException e) {
            return -1;
        }
    }

    /**
     * See the general contract of the <code>mark</code>
     * method of <code>InputStream</code>.
     *
     * @param readlimit the maximum limit of bytes that can be read before
     *                  the mark position becomes invalid.
     * @see com.jmobilecore.comm.BufferedInputStream#reset()
     */
    public void mark(int readlimit) {
        marklimit = readlimit;
        mark = pos;
    }

    /**
     * See the general contract of the <code>reset</code>
     * method of <code>InputStream</code>.
     * <p/>
     * If <code>markpos</code> is <code>-1</code>
     * (no mark has been set or the mark has been
     * invalidated), an <code>IOException</code>
     * is thrown. Otherwise, <code>pos</code> is
     * set equal to <code>markpos</code>.
     *
     * @see com.jmobilecore.comm.BufferedInputStream#mark(int)
     */
    public void reset() {
        pos = mark;
    }

    /**
     * Tests if this input stream supports the <code>mark</code>
     * and <code>reset</code> methods. The <code>markSupported</code>
     * method of <code>BufferedInputStream</code> returns
     * <code>true</code>.
     *
     * @return a <code>boolean</code> indicating if this stream type supports
     *         the <code>mark</code> and <code>reset</code> methods.
     * @see java.io.InputStream#mark(int)
     * @see java.io.InputStream#reset()
     */
    public boolean markSupported() {
        return true;
    }

    /**
     * Closes this input stream and releases any system resources
     * associated with the stream.
     *
     * @throws IOException if an I/O error occurs.
     */
    public void close() throws IOException {
        if (in != null) {
            in.close();
        }
        in = null;
        buf = null;
    }
}
