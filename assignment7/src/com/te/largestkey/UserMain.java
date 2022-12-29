package com.te.largestkey;

import java.util.HashMap;
import java.util.Iterator;

public class UserMain {
	public static String getMaxKeyValue(HashMap<Integer, String> hashMap) {
		Integer maximum=0;
		String string1= "";
		Iterator<Integer> iterator = hashMap.keySet().iterator();
		while (iterator.hasNext()) {
			Integer key =  iterator.next();
			if (key>maximum) {
				maximum=key;
				String value= hashMap.get(key);
				string1=value;
			}
		}
		return string1;
	}

}
