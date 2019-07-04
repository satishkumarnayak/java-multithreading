package com.instanceofcake.multithreading.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

	public static void main(String[] args) {

		List<Future<String>> futures = new ArrayList();

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 12; i++) {
			Future<String> future = executorService.submit(new Processor(i));
			futures.add(future);
		}
		for (Future<String> f : futures) {
			try {
				String output = f.get();
				System.out.println(output);
			} catch (InterruptedException e) {

				e.printStackTrace();
			} catch (ExecutionException e) {

				e.printStackTrace();
			}
		}
		executorService.shutdown();
	}
}
class Processor implements Callable<String> {

	int id;

	public Processor(int id) {
		super();
		this.id = id;
	}

	public String call() throws Exception {
		Thread.sleep(1000);
		return "Id->" + id;
	}

}