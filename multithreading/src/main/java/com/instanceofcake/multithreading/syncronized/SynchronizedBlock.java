package com.instanceofcake.multithreading.syncronized;

public class SynchronizedBlock {

	int count1;
	int count2;

	Object lock1 = new Object();
	Object lock2 = new Object();

	public void add1() {
		synchronized (lock1) {
			for (int i = 0; i < 100; i++) {
				count1++;
			}
		}
	}

	public void add2() {
		synchronized (lock2) {
			for (int i = 0; i < 100; i++) {
				count2++;
			}
		}
	}

	public static void main(String[] args) {

		SynchronizedBlock demo = new SynchronizedBlock();
		demo.compute();

	}

	public void compute() {

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				add1();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {
				add2();

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

		System.out.println("Count1->" + count1 + " Count2->" + count2);

	}

}
