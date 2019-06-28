package com.instanceofcake.multithreading.thread;

public class ThreadDrive {

	public static void main(String[] args) {
		Runner1 t1 = new Runner1();
		Runner2 t2 = new Runner2();

		t1.start();
		t2.start();

	}

}

class Runner1 extends Thread {

	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Runner1----->" + i);
		}

	}
}

class Runner2 extends Thread {

	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Runner2->" + i);
		}

	}
}