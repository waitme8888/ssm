package com.waitme.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			Future<String> futureTask = service.submit(new Task("task"+i));
			try {
				System.out.println("get result...");
				String result = futureTask.get();
				System.out.println("result:" + result);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class Task implements Callable<String> {
	String task;
	public Task(String task) {
		this.task = task;
	}

	@Override
	public String call() throws Exception {
		System.out.println("start task：" +  task);
		Thread.sleep(5000);
		System.out.println("end task：" +  task);
		return task;
	}
	
}
