package com.example.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;

public class BinanceSyncHttpClient {
    private static final String URL = "https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT";

    public static void main(String[] args) throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Accept", "application/json")
                .build();
        /*
        long start = System.currentTimeMillis();
        for (var i=0;i<10;++i){
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }
        long stop = System.currentTimeMillis();
        System.err.println("Duration: "+(stop-start)+" ms.");

         */
        for (var i=0;i<100;++i){
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                  .thenAccept( resp -> System.err.println(resp.body()) );
        }
        TimeUnit.HOURS.sleep(1);

    }
}
