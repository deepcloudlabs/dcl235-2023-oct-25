package com.example.lottery.service.business;

import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

import com.example.lottery.service.LotteryService;
import com.example.random.service.RandomService;

@SuppressWarnings("unused")
public class StandardLotteryService implements LotteryService {
	private RandomService randomService;

	public void setRandomService(RandomService randomService) {
		this.randomService = randomService;
		System.err.println("setRandomService(%s)".formatted(randomService.getClass()));
	}

	@Override
	public List<Integer> draw(int max, int size) {
		A a= new A();
		IntUnaryOperator _3n_plus_one = u -> {
			if (u%2 == 0)
				return u/2;
			return 3 * u + 1;
		};
		return IntStream.generate(() -> randomService.generate(1, max))
				.distinct()
				.map(_3n_plus_one)
				//.map(a::_3n_plus_one)
				.limit(size)
				.sorted()
				.boxed()
				.toList();
	}

}
@SuppressWarnings("serial")
class MyError extends Exception{}

@SuppressWarnings("unused")
class A {
	private int state; 
	public int _3n_plus_one(int u) throws MyError{
		if (u%2 == 0)
			return u/2;
		return 3 * u + 1;		
	}
}