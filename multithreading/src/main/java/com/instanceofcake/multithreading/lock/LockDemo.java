package com.instanceofcake.multithreading.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

	static Lock lock = new ReentrantLock(true);
	public static int counter;

	public static void increment() {
		try {
			lock.lock();
			for (int i = 0; i < 1000; i++) {
				counter++;
			}
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				increment();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {
				increment();

			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Final Count---->" + counter);
	}

}
