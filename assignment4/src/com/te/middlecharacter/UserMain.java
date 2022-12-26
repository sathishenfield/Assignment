package com.te.middlecharacter;

import java.util.Iterator;

public class UserMain {

	public static String getMiddleChars(String input) {
		
		Integer startIndex=(input.length()-1)/2;
		Integer lastIndex=startIndex+2;
		
		String output=input.substring(startIndex, lastIndex);
		return output;
		
	}

}
