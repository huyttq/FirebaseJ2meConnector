/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heaton.threads.test;

import com.heaton.threads.Done;

/**
 * This class shows an example worker thread that can
 * be used with the thread pool. It demonstrates the main
 * points that should be included in any worker thread. Use
 * this as a starting point for your own threads.
 * 
 * @author Jeff Heaton (http://www.jeffheaton.com)
 * @version 1.0
 */
public class TestWorkerThread implements Runnable {

	static private int count = 0;
	private int taskNumber;
	protected Done done;

	TestWorkerThread() {
		count++;
		taskNumber = count;
	}

	public void run() {
		for (int i = 0; i < 100; i += 2) {
			System.out.println("Task number: " + taskNumber + ",percent complete = " + i);
			try {
				Thread.sleep((int) (Math.random() * 50));
			} catch (InterruptedException e) {
			}
		}
	}
}
