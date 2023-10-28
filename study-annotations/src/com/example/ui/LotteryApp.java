package com.example.ui;

import com.example.model.LotteryViewModel;
import com.example.service.RandomNumberGenerator;

public class LotteryApp {

	public static void main(String[] args) throws Exception, IllegalAccessException {
		LotteryViewModel model = new LotteryViewModel();
		RandomNumberGenerator.generate(model);
		System.out.println(model.getNumbers());		
	}

}
