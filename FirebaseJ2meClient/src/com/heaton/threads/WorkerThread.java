package com.heaton.threads;

import j2mex.realtime.RealtimeThread;

/**
 * The
 * worker
 * threads
 * that
 * make
 * up
 * the
 * thread
 * pool.
 *
 * @author
 * Jeff
 * Heaton
 * @version
 * 1.0
 */
class WorkerThread extends RealtimeThread {

	/**
	 * True
	 * if
	 * this
	 * thread
	 * is
	 * currently
	 * processing.
	 */
	public boolean busy;
	/**
	 * The
	 * thread
	 * pool
	 * that
	 * this
	 * object
	 * belongs
	 * to.
	 */
	public ThreadPool owner;

	/**
	 * The
	 * constructor.
	 *
	 * @param
	 * o
	 * the
	 * thread
	 * pool
	 */
	WorkerThread(ThreadPool o) {
		owner = o;
	}

	/**
	 * Scan
	 * for
	 * and
	 * execute
	 * tasks.
	 */
	public void run() {
		Runnable target = null;

		do {
			target = owner.getAssignment();
			if (target != null) {
				target.run();
				owner.done.workerEnd();
			}
		} while (target != null);
	}
}