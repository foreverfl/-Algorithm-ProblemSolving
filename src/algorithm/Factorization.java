package algorithm;

import java.util.ArrayList;
import java.util.List;

// 소인수분해
public class Factorization {
	public static List<Integer> factorization(int num) {
		int sqrt = (int) Math.sqrt(num);
		List<Integer> list = new ArrayList<>();

		for (int i = 2; i <= sqrt; i++) {
			while (num % i == 0) {
				list.add(i);
				num /= i;
			}

		}
		
		if (num != 1) {
			list.add(num);
		}

		return list;
	}
}
