package com.instanceofcake.multithreading.waitnotify;

public class WaitNotifyProcessor {

	public void consumer() throws InterruptedException {

		synchronized (this) {

			
			System.out.println("In consumer.....");
			this.wait();
			System.out.println("In consumer again...");
		}

	}

	public void producer() throws InterruptedException {

		Thread.sleep(1000);
		synchronized (this) {
		
			System.out.println("In producer.....");
			this.notify();

		}

	}

	public static void main(String[] args) {

		final WaitNotifyProcessor processor = new WaitNotifyProcessor();

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				try {
					processor.producer();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {
				try {
					processor.consumer();
				} catch (InterruptedException e) {

					e.printStackTrace();
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

	}

}
