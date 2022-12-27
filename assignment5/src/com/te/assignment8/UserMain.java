package com.te.assignment8;

import java.util.Arrays;

public class UserMain {
	public static void calculateMedian(Integer[] array) {
		Integer oddMedian;
		Double evenMedian = null;
		Arrays.sort(array);
		if(array.length%2==0) {
			evenMedian=(double) ((array[array.length/2]+array[(array.length/2)-1]))/2;
			System.out.println(Math.round(evenMedian));
		}
	
		
		else {
			oddMedian=array[array.length/2];
			System.out.println(oddMedian);
		}
	}

}
