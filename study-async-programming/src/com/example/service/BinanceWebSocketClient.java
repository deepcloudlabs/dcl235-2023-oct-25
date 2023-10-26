package com.example.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

public class BinanceWebSocketClient implements WebSocket.Listener{
    private static final String URL = "wss://stream.binance.com:9443/ws/btcusdt@trade";

    public static void main(String[] args) throws InterruptedException {
        HttpClient.newHttpClient().newWebSocketBuilder()
                .buildAsync(URI.create(URL), new BinanceWebSocketClient());
        TimeUnit.HOURS.sleep(1);
    }

    @Override
    public void onOpen(WebSocket webSocket) {
        System.err.println("Connected to Binance");
        webSocket.request(1);
    }

    @Override
    public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
        System.out.println(data);
        webSocket.request(1);
        return null;
    }

    @Override
    public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
        System.err.println("Connection is closed.");
        return null;
    }

    @Override
    public void onError(WebSocket webSocket, Throwable error) {
        System.err.println("Error: "+error.getMessage());
    }
}
