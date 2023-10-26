package com.example.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class AsyncLotteryService {
    // Sync
    public CompletableFuture<List<Integer>> draw(int max, int size) {
        return CompletableFuture.supplyAsync( () -> {
            System.err.println("Thread ("+Thread.currentThread().getName()+") is running async task...");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) { }
            return ThreadLocalRandom.current().ints(1, max)
                    .distinct()
                    .limit(size)
                    .sorted()
                    .boxed()
                    .collect(Collectors.toList());

        });
    }
}
