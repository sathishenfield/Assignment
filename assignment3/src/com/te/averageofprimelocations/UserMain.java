package com.te.averageofprimelocations;

public class UserMain {
	public static Double averageElements(Integer[] array) {
		Integer primeIndex=0;
		Integer count=0;
		Double sum=0.0;
		Double primeCount=0.0;
		Double averageElement=0.0;
		
	    int firstelement=array[0];

		if (array.length==1) {
			return (double) firstelement;
		}

		for (int i = 2; i < array.length; i++) {

			primeIndex=i;
			for (int j = 1; j <=primeIndex; j++) {
				if (primeIndex%j==0) {
					
                    count++;
				}
			
			}
			
			if (count==2) {
				
				sum+=array[i];
				primeCount++;
			}
			count=0;
		}
		System.out.println(sum);
		System.out.println(primeCount);
		averageElement= (sum/primeCount);
		System.out.println(averageElement);
		return (double) averageElement;

	}

}
