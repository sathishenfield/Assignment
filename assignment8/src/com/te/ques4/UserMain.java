package com.te.ques4;

import java.util.HashMap;
import java.util.Map;

public class UserMain {
	public static Float costEstimator(HashMap<String, Float> map, String[] array) {
		Float result=0.0f;
		for (int i = 0; i < array.length; i++) {
			for (Map.Entry<String, Float> entry : map.entrySet()) {
				if(entry.getKey().equalsIgnoreCase(array[i])) {
					result += entry.getValue();
				}	
			}
		}
		return result;
	}

}
