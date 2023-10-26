package com.example;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import com.example.event.TradeEvent;

@SuppressWarnings("deprecation")
public class StudyLegacyObserverPattern {

	public static void main(String[] args) {
		TradeObservable observable = new TradeObservable();
		Observer slowObserver = (o, event) -> {
			System.err.println("Slow observer has received an event: "+event);
			try {TimeUnit.SECONDS.sleep(3);} catch(Exception e) {}	
		};
		Observer fastObserver = (o, event) -> {
			System.err.println("Fast observer has received an event: "+event);
		};
		observable.addObserver(slowObserver);
		observable.addObserver(fastObserver);
		var events = List.of(
			new TradeEvent("btcusdt",1, 1),	
			new TradeEvent("ethusdt",2, 2),	
			new TradeEvent("btcusdt",3, 3),	
			new TradeEvent("btcusdt",4, 4),	
			new TradeEvent("btcusdt",5, 5)	
		);
		events.forEach(observable::notifyObservers);
	}

}

@SuppressWarnings("deprecation")
class TradeObservable extends Observable {

	// event -> Domain/Business Event
	@Override
	public void notifyObservers(Object event) {
		setChanged();
		super.notifyObservers(event);
	}
	
}