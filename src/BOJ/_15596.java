package BOJ;

class _15596 {
    long sum(int[] a) { // It gets inputs as an array 'a.'
		long sum = 0;
        
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
}
 
