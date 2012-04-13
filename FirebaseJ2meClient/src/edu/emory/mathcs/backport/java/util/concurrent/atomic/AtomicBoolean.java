/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/licenses/publicdomain
 */

package edu.emory.mathcs.backport.java.util.concurrent.atomic;

import j2me.io.Serializable;

/**
 * A {@code boolean} value that may be updated atomically. See the
 * {@link edu.emory.mathcs.backport.java.util.concurrent.atomic} package specification for
 * description of the properties of atomic variables. An
 * {@code AtomicBoolean} is used in applications such as atomically
 * updated flags, and cannot be used as a replacement for a
 * {@link java.lang.Boolean}.
 *
 * @since 1.5
 * @author Doug Lea
 */
public class AtomicBoolean implements Serializable {
    private static final long serialVersionUID = 4654671469794556979L;

    private volatile int value;

    /**
     * Creates a new {@code AtomicBoolean} with the given initial value.
     *
     * @param initialValue the initial value
     */
    public AtomicBoolean(boolean initialValue) {
        value = initialValue ? 1 : 0;
    }

    /**
     * Creates a new {@code AtomicBoolean} with initial value {@code false}.
     */
    public AtomicBoolean() {
    }

    /**
     * Returns the current value.
     *
     * @return the current value
     */
    public final boolean get() {
        return value != 0;
    }

    /**
     * Atomically sets the value to the given updated value
     * if the current value {@code ==} the expected value.
     *
     * @param expect the expected value
     * @param update the new value
     * @return true if successful. False return indicates that
     * the actual value was not equal to the expected value.
     */
    public final synchronized boolean compareAndSet(boolean expect, boolean update) {
        if (expect == (value != 0)) {
            value = update ? 1 : 0;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Atomically sets the value to the given updated value
     * if the current value {@code ==} the expected value.
     *
     * <p>May <a href="package-summary.html#Spurious">fail spuriously</a>
     * and does not provide ordering guarantees, so is only rarely an
     * appropriate alternative to {@code compareAndSet}.
     *
     * @param expect the expected value
     * @param update the new value
     * @return true if successful.
     */
    public synchronized boolean weakCompareAndSet(boolean expect, boolean update) {
        if (expect == (value != 0)) {
            value = update ? 1 : 0;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Unconditionally sets to the given value.
     *
     * @param newValue the new value
     */
    public final synchronized void set(boolean newValue) {
        value = newValue ? 1 : 0;
    }

    /**
     * Eventually sets to the given value.
     *
     * @param newValue the new value
     * @since 1.6
     */
    public final synchronized void lazySet(boolean newValue) {
        value = newValue ? 1 : 0;
    }

    /**
     * Atomically sets to the given value and returns the previous value.
     *
     * @param newValue the new value
     * @return the previous value
     */
    public final synchronized boolean getAndSet(boolean newValue) {
        int old = value;
        value = newValue ? 1 : 0;
        return old != 0;
    }

    /**
     * Returns the String representation of the current value.
     * @return the String representation of the current value.
     
    public String toString() {
        return Boolean.toString(get());
    }*/

}
