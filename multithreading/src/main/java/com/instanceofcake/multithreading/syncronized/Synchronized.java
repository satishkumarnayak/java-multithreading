package com.instanceofcake.multithreading.syncronized;

public class Synchronized {

	int counter;

	public static void main(String[] args) {

		Synchronized syncronized = new Synchronized();
		syncronized.process();

	}

	public synchronized void increment() {
		++counter;

	}

	public void process() {

		Thread t1 = new Thread(new Runnable() {

			public void run() {

				for (int i = 0; i < 100; i++) {
					increment();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {

				for (int i = 0; i < 100; i++) {
					increment();
				}

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

		System.out.println("Final Count:" + counter);
	}

}
