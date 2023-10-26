package com.example.random.service.business;

import java.util.concurrent.ThreadLocalRandom;

import com.example.random.service.QualityLevel;
import com.example.random.service.RandomService;
import com.example.random.service.ServiceQuality;

@ServiceQuality(QualityLevel.FAST)
public class StandardRandomService implements RandomService {

	@Override
	public int generate(int min, int max) {
		System.out.println("StandardRandomService::generate");
		return ThreadLocalRandom.current().nextInt(min, max+1);
	}

}
