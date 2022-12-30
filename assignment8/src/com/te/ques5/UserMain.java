package com.te.ques5;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class UserMain {
	public static TreeMap<String, Integer> calculateDiscount(HashMap<String, String> map1,
			HashMap<String, Integer> map2) {
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		for (Map.Entry<String, String> entry : map1.entrySet()) {
			int year = Period.between(LocalDate.parse(entry.getValue(), DateTimeFormatter.ofPattern("dd-M-yyyy")),
					LocalDate.parse("2015-01-01")).getYears();

			for (Map.Entry<String, Integer> entry2 : map2.entrySet()) {
				if (entry2.getKey().equals(entry.getKey())) {
					if (year >= 5 && entry2.getValue() >= 20000) {
						int discount = (entry2.getValue() * 20) / 100;
						treeMap.put(entry2.getKey(), discount);
					} else if (year < 5 && entry2.getValue() >= 20000) {
						int discount = (entry2.getValue() * 10) / 100;
						treeMap.put(entry2.getKey(), discount);
					} else if (year >= 5 && entry2.getValue() < 20000) {
						int discount = (entry2.getValue() * 15) / 100;
						treeMap.put(entry2.getKey(), discount);
					} else if (year < 5 && entry2.getValue() < 20000) {
						int discount = (entry2.getValue() * 5) / 100;
						treeMap.put(entry2.getKey(), discount);
					}
				}
			}

		}
		return treeMap;
	}

}
