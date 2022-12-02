package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solving_BOJ_06333_SmithNumbers {

	private static boolean[] isNotPrime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		checkPrime(99999999);

		while (true) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0)
				break;
			
			if(input == 99999999)
				break;

			input++;

			if (!isNotPrime[input]) {
				input++;
			}

			String continuous = Integer.toString(input);
			int sum1 = calcSum(continuous);

			List<Integer> list = factorization(input);
			String continuousFac = "";
			for (int i = 0; i < list.size(); i++) {
				continuousFac += list.get(i);
			}
			int sum2 = calcSum(continuousFac);

			if (sum1 == sum2) {
				sb.append(input).append('\n');
			}
		}

		System.out.println(sb.toString());

	}

	private static List<Integer> factorization(int num) {
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

	private static int calcSum(String str) {
		int res = 0;

		for (int i = 0; i < str.length(); i++) {
			res += (str.charAt(i) - '0');
		}

		return res;

	}

	private static void checkPrime(int num) {
		isNotPrime = new boolean[num + 1];
		/*
		소수가 아닌 index = true
		소수인 index = false
		*/

		// 2 미만의 N 을 입력받으면 소수는 판별할 필요 없으므로 바로 리턴
		if (num < 2) {
			return;
		}

		isNotPrime[0] = isNotPrime[1] = true;

		for (int i = 2; i <= Math.sqrt(num); i++) {

			// 이미 체크된 배열이면 다음 반복문으로 skip
			if (isNotPrime[i] == true) {
				continue;
			}

			// i 의 배수들을 걸러주기 위한 반복문
			for (int j = i * i; j < isNotPrime.length; j = j + i) {
				isNotPrime[j] = true;
			}
		}
	}

}
