package com.instanceofcake.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();
	//	ExecutorService executorService = Executors.newFixedThreadPool(10);
//		ExecutorService executorService = Executors.newSingleThreadExecutor();

		for (int i = 0; i < 5; i++) {
		//	executorService.submit(new Worker());
			executorService.execute(new Worker());
		}

		executorService.shutdown();
	}

}

class Worker implements Runnable {

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}