package com.te.newword;

public class UserMain {
	

	public static String formNewWord(String input, Integer length) {

		Integer length2 = 2 * length;
		String string = new String();

		if (input.length() > length2) {
			string = input.substring(0, length) + input.substring(input.length() - length, input.length());
			return string;
		} else {
			return null;
		}

	}

}
