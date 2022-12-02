package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Programmers_120852_Factorization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] solution(int n) {
		Set<Integer> set = factorization(n);

		int[] ans = new int[set.size()];
		Iterator<Integer> iterator = set.iterator();
		int idx = 0;
		while (iterator.hasNext()) {
			ans[idx++] = iterator.next();
		}
		
		Arrays.sort(ans);

		return ans;
	}

	public static Set<Integer> factorization(int num) {
		int sqrt = (int) Math.sqrt(num);
		Set<Integer> set = new HashSet<>();

		for (int i = 2; i <= sqrt; i++) {
			while (num % i == 0) {
				set.add(i);
				num /= i;
			}

		}

		if (num != 1) {
			set.add(num);
		}

		return set;
	}

}
