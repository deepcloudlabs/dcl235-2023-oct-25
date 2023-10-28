package com.example.exercises;

import static java.lang.Long.compare;

import java.util.function.Supplier;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.util.CountrySummaryStatistics;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise13 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	private static final Supplier<CountrySummaryStatistics> countrySummaryStatisticsSupplier = () -> new CountrySummaryStatistics(
			(l, r) -> compare(l.getPopulation(), r.getPopulation()));

	public static void main(String[] args) {
		// Find the countries with the minimum and the maximum population
		final CountrySummaryStatistics countrySummaryStatistics = worldDao.findAllCountries().stream().collect(
				countrySummaryStatisticsSupplier, CountrySummaryStatistics::accept, CountrySummaryStatistics::combine);
		System.out.println(countrySummaryStatistics);
	}

}

