package com.example.model;

import java.util.List;

public class LotteryViewModel {
	@RandomNumber(max=60)
	private List<Integer> numbers;

	public List<Integer> getNumbers() {
		return numbers;
	}

}
