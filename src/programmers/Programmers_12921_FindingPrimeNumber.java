package programmers;

import java.util.Arrays;

public class Programmers_12921_FindingPrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static boolean[] isPrime;

	public int solution(int n) {
		checkPrime(n);

		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (isPrime[i])
				answer++;
		}
		return answer;
	}

	private static void checkPrime(int num) {
		isPrime = new boolean[num + 1];
		Arrays.fill(isPrime, true);
		/*
		소수가 아닌 index = true
		소수인 index = false
		*/

		// 2 미만의 N 을 입력받으면 소수는 판별할 필요 없으므로 바로 리턴
		if (num < 2) {
			return;
		}

		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i <= Math.sqrt(num); i++) {

			// 이미 체크된 배열이면 다음 반복문으로 skip
			if (isPrime[i] == false) {
				continue;
			}

			// i 의 배수들을 걸러주기 위한 반복문
			for (int j = i * i; j < isPrime.length; j = j + i) {
				isPrime[j] = false;
			}
		}
	}

}
