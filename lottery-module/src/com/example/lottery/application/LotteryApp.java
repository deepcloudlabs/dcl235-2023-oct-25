package com.example.lottery.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ServiceLoader;

import com.example.lottery.service.business.StandardLotteryService;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomService;
import com.example.random.service.ServiceQuality;

public class LotteryApp {
	private static QualityLevel qualityLevel;
	static {
		var props = new Properties();
		try {
			props.load(new FileInputStream(new File("lottery.properties")));
			qualityLevel = QualityLevel.valueOf(props.getProperty("quality.level"));
		} catch (IOException e) {
			System.err.println("%s".formatted(e.getMessage()));
		}
	}
	public static void main(String[] args) {
		StandardLotteryService lotteryService = new StandardLotteryService();
		var randomServices = ServiceLoader.load(RandomService.class);
		randomServices.forEach(System.err::println);
		for (var randomService : randomServices) {
			var clazz = randomService.getClass();
			if (clazz.isAnnotationPresent(ServiceQuality.class)) {
				var serviceQuality = clazz.getAnnotation(ServiceQuality.class);
				if (serviceQuality.value() == qualityLevel) {
					lotteryService.setRandomService(randomService);					
					break;
				}
			}
		}
		lotteryService.draw(60, 6, 10)
		              .forEach(System.out::println);

	}

}
