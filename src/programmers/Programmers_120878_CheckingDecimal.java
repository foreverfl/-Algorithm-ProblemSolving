package programmers;

import java.util.ArrayList;
import java.util.List;

public class Programmers_120878_CheckingDecimal {

	public static void main(String[] args) {
		System.out.println(solution(7, 20));
		System.out.println(solution(11, 22));
	}

	public static int solution(int a, int b) {
		int GCD = calcGCD(a, b);
		a /= GCD;
		b /= GCD;

		List<Integer> list = factorization(b);

		for (int num : list) {
			if (num != 2 && num != 5) {
				return 2;
			}
		}
		return 1;
	}

	// 최대공약수(Greatest Common Denominator)
	private static int calcGCD(int a, int b) {
		// 무조건 a가 큰 수여야 된다.
		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		if (a % b == 0) {
			return b;
		}
		return calcGCD(b, a % b);
	}

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
