package com.instanceofcake.multithreading.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

	public static void main(String[] args) {

		final Worker worker = new Worker();

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				try {
					worker.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {
				try {
					worker.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t2.join();
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class Worker {

	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public void consumer() throws InterruptedException {
		lock.lock();
		System.out.println("Consumer....");

		condition.await();

		System.out.println("Consumer Again....");
		lock.unlock();

	}

	public void producer() throws InterruptedException {
		Thread.sleep(3000);
		lock.lock();

		System.out.println("producer....");

		condition.signal();

		lock.unlock();

	}

}
