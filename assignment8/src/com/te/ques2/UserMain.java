package com.te.ques2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserMain {
	public static Boolean isLeapYear(String input) {
//		String[] split = input.split("/");
//		Integer year = Integer.parseInt(split[2]);
		Integer year=LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/M/yyyy")).getYear();
		Boolean result = false;
		if (year % 4 == 0) {
			result = true;
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					result = true;
				} else {
					result = false;
				}
			}

		}
		return result;
	}

}
