/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heaton.threads.test;

import com.heaton.threads.ThreadPool;
import org.junit.Test;

public class ThreadPoolTest {

	public ThreadPoolTest() {
	}

	@Test
	public void runThreadPool() {
		ThreadPool pool = new ThreadPool(1);

		for (int i = 1; i < 3; i++) {
			pool.assign(new TestWorkerThread());
		}

		pool.complete();

		System.out.println("All tasks are done.");
	}
}
