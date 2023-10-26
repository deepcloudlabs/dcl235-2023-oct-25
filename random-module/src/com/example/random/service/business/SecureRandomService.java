package com.example.random.service.business;

import java.security.SecureRandom;
import java.util.Random;

import com.example.random.service.QualityLevel;
import com.example.random.service.RandomService;
import com.example.random.service.ServiceQuality;

@ServiceQuality(QualityLevel.SECURE)
public class SecureRandomService implements RandomService {

	private Random random = new SecureRandom();;

	@Override
	public int generate(int min, int max) {
		System.out.println("SecureRandomService::generate");
		return random.nextInt(min, max+1);
	}

}
