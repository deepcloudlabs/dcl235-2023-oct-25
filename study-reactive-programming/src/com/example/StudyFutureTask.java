package com.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class StudyFutureTask {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.err.println("Application is just started!");
		System.err.println("Before calling fun!");
		fun().thenAccept(value -> {			
			System.err.println("%s prints the value: %d".formatted(Thread.currentThread().getName(),value));
		});
		System.err.println("After calling fun!");
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e) {
			System.out.println(e.getSuppressed());
		}
		
		System.err.println("Appliction is done!");
	}
	// async
	public static CompletableFuture<Integer> fun() { 
		return CompletableFuture.supplyAsync(() -> {
			System.err.println("%s is running fun()...".formatted(Thread.currentThread().getName()));
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				System.out.println(e.getSuppressed());
			}
			return 42;
	    });
	}
}
