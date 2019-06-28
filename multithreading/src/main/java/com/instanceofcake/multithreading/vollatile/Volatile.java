package com.instanceofcake.multithreading.vollatile;

/*
 * We make sure that that given variable is going to be fetched from the main memory instead of the cache and sometimes it can prove to be very very important. 
 * And it was important to know that if we use this volatile keyword then basically it's not going to be the best as far as performance is concerned. 
 * It's going to be a bit slower.
 */
public class Volatile {

	public static void main(String[] args) {

		Worker worker = new Worker();
		Thread t1 = new Thread(worker);
		t1.start();

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		worker.setTerminated(true);

	}

}

class Worker implements Runnable {

	volatile boolean isTerminated = false;

	public void run() {

		while (!isTerminated) {
			System.out.println("Worker working");
		}

	}

	public boolean isTerminated() {
		return isTerminated;
	}

	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}

}