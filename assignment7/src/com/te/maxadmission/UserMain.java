package com.te.maxadmission;

import java.util.HashMap;
import java.util.Iterator;

public class UserMain {

	public static Integer getYear(HashMap<Integer, Integer> hashMap) {
		Integer maximum=0;
		Integer key=0;
		Integer value=0;
		Integer largest=0;
		Iterator<Integer> iterator = hashMap.keySet().iterator();
		while (iterator.hasNext()) {
			 key = iterator.next();
			value=hashMap.get(key);
			if (value>maximum) {
				maximum=value;
				largest=key;
			}
		}
		return largest;
	}


}
