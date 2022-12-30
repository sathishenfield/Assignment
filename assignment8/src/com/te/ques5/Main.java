package com.te.ques5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		TreeMap<String, Integer> resultMap;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter size of hashmap and values");
		int size=scanner.nextInt();
		HashMap<String, String> map1=new HashMap<String, String>(size);
		HashMap<String, Integer> map2=new HashMap<String, Integer>(size);
		for (int i = 0; i < size; i++) {
			String key=scanner.next();
			map1.put(key, scanner.next());
			for (int j = 0; j < size; j++) {
				map2.put(key, scanner.nextInt());
				break;
			}
		}
		resultMap=UserMain.calculateDiscount(map1, map2);
		for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key+":"+val);
		}
	}

}
