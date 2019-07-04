package com.instanceofcake.multithreading.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 12; i++) {
			Thread t = new Thread(new Runnable() {

				public void run() {

					Downloader.INSTANCE.downloadData();
				}
			});

			executorService.execute(t);

		}

		executorService.shutdown();

	}

}

enum Downloader {

	INSTANCE;

	private Semaphore semaphore = new Semaphore(5, true);

	public void downloadData() {

		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		download();

		semaphore.release();

	}

	private void download() {
		System.out.println("Downloading data");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
