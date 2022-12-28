package com.te.assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class UserMain {
	public static String[] convertToStringArray(Integer input, ArrayList<String> arrayListInput) {
		String[] strings =new String[input];
		Integer i=0;
		Collections.sort(arrayListInput);
		Iterator<String> iterator= arrayListInput.iterator();
		while (iterator.hasNext()) {
			strings[i]=iterator.next();
			++i;
			
		}
		return strings;
	}

}
