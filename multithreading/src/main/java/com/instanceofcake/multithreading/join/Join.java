package com.instanceofcake.multithreading.join;

/**
 * 
	Join gives us ability to be able to wait for a given thread to finish its task.
 *
 */
public class Join {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runner1());
		Thread t2 = new Thread(new Runner2());

		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished ");

	}

}

class Runner1 implements Runnable {

	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Runner1------>" + i);
		}

	}
}

class Runner2 implements Runnable {

	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Runner2-->" + i);
		}

	}
}