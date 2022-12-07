package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmers_135807_DividingNumberCards {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 10, 17 }, new int[] { 5, 20 }));
		System.out.println(solution(new int[] { 10, 20 }, new int[] { 5, 17 }));
		System.out.println(solution(new int[] { 14, 35, 119 }, new int[] { 18, 30, 102 }));
	}

	public static int solution(int[] arrayA, int[] arrayB) {
		int A = divide(arrayA, arrayB);
		int B = divide(arrayB, arrayA);

		return Math.max(A, B);
	}

	public static int divide(int[] arrayA, int[] arrayB) {
		int size = arrayA.length;
		int GCD = arrayA[0];
		for (int i = 1; i < size; i++) {
			GCD = calcGCD(GCD, arrayA[i]);
		}

		List<Integer> list = findDivisor(GCD);

		if (list.size() == 1)
			return 0;

		int answer = 0;
		for (int i = 0; i < list.size(); i++) {
			boolean isPossible = true;
			for (int j = 0; j < size; j++) {
				if (arrayB[j] % list.get(i) == 0) {
					isPossible = false;
				}
			}
			if (isPossible) {
				answer = list.get(i);
				break;
			}

		}

		return answer;
	}

	private static int calcGCD(int a, int b) {
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

	private static List<Integer> findDivisor(int num) {
		int sqrt = (int) Math.sqrt(num);
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= sqrt; i++) {
			if (num % i == 0) {
				list.add(i);

				if (num / i != i) {
					list.add(num / i);
				}
			}
		}

		Collections.sort(list, Collections.reverseOrder());

		return list;
	}

}
