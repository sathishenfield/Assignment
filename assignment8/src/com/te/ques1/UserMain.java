package com.te.ques1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UserMain {
	public static String getAge(String input) {
		LocalDate date = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/M/yyyy"));
		LocalDate date2 = LocalDate.of(2015, 01, 01);
		Integer years = Period.between(date, date2).getYears();
		if (years > 18) {
			return "eligible";
		} else {
			return "not-eligible";
		}
	}

}
