package programmers;

import java.util.Arrays;

public class Programmers_120846_FindingCompositeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static boolean[] isPrime;

	public static int solution(int n) {
		checkPrime(n);
		int answer = 0;
		for (int i = 2; i <= n; i++) {
			if (!isPrime[i])
				answer++;
		}
		return answer;
	}

	private static void checkPrime(int num) {
		isPrime = new boolean[num + 1];
		Arrays.fill(isPrime, true);

		if (num < 2) {
			return;
		}

		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i <= Math.sqrt(num); i++) {

			if (isPrime[i] == false) {
				continue;
			}

			for (int j = i * i; j < isPrime.length; j = j + i) {
				isPrime[j] = false;
			}
		}
	}

}
