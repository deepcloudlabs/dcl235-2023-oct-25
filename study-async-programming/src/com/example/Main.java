package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import com.example.service.AsyncLotteryService;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AsyncLotteryService lotteryService = new AsyncLotteryService();
        var numbers= new ArrayList<CompletableFuture< List<Integer> >>();
        System.err.println("App is running...");
        for (int i=0;i<100;++i){
            numbers.add(lotteryService.draw(50,6)); // non-blocking
        }
        System.err.println("for has ended!");
                                           // callback function : Lambda Expression
        Consumer<List<Integer>> observer = nums -> System.err.println(nums);
        numbers.forEach( cf -> {
            cf.thenAccept(observer);
        });
        TimeUnit.HOURS.sleep(1);
    }
}
