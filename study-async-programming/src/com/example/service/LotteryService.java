package com.example.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class LotteryService {
    // Sync
    public List<Integer> draw(int max, int size) {
        return ThreadLocalRandom.current().ints(1, max)
                .distinct()
                .limit(size)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }
}
