package com.example;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

import com.example.event.TradeEvent;

public class StudyReactiveObserver {

	public static void main(String[] args) {
		SubmissionPublisher<TradeEvent> publisher = new SubmissionPublisher<>();
		publisher.subscribe(new FastObserver());
		publisher.subscribe(new SlowObserver());
		var events = List.of(
				new TradeEvent("btcusdt",1, 1),	
				new TradeEvent("ethusdt",2, 2),	
				new TradeEvent("btcusdt",3, 3),	
				new TradeEvent("btcusdt",4, 4),	
				new TradeEvent("btcusdt",5, 5)	
			);
		events.forEach(publisher::submit);	
		try {TimeUnit.SECONDS.sleep(20);	} catch (Exception e) {}
		publisher.close();
		System.err.println("Application is done!");
	}

}

class FastObserver implements Flow.Subscriber<TradeEvent> {

	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(TradeEvent event) {
		System.err.println("["+Thread.currentThread().getName()+"] Fast observer has received an event: " + event);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		System.err.println("Fast observer has an error: " + throwable.getMessage());
	}

	@Override
	public void onComplete() {
		System.err.println("Fast observer is completed!");
	}

}

class SlowObserver implements Flow.Subscriber<TradeEvent> {

	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(TradeEvent event) {
		System.err.println("["+Thread.currentThread().getName()+"] Slow observer has received an event: " + event);
		try {TimeUnit.SECONDS.sleep(3);	} catch (Exception e) {}
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		System.err.println("["+Thread.currentThread().getName()+"] Slow observer has an error: " + throwable.getMessage());
	}

	@Override
	public void onComplete() {
		System.err.println("Slow observer is completed!");
	}

}