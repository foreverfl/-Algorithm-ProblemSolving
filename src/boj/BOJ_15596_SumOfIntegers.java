package boj;

class BOJ_15596_SumOfIntegers {
    long sum(int[] a) { // It gets inputs as an array 'a.'
		long sum = 0;
        
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
}
 
