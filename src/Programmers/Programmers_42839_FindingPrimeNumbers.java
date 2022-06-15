package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Programmers_42839_FindingPrimeNumbers {

	public static void main(String[] args) {
//		String numbers_1 = "17";
//		System.out.println(solution(numbers_1));
//
//		String numbers_2 = "011";
//		System.out.println(solution(numbers_2));

		String numbers_3 = "1231";
		System.out.println(solution(numbers_3));

	}

	static Set<Integer> set = new HashSet<>();

	public static int solution(String numbers) {
		char[] arr = numbers.toCharArray();
		boolean[] visited = new boolean[numbers.length()];

		for (int i = 1; i <= numbers.length(); i++) {
			backTracking(0, numbers.length(), i, "", arr, visited);
		}

		int ans = 0;
		Iterator<Integer> iterator = set.iterator();

		while (iterator.hasNext()) {
			if (isPrime(iterator.next()))
				ans++;
		}

		set.clear();

		return ans;
	}

	public static void backTracking(int depth, int n, int r, String now, char[] arr, boolean[] visited) {
		if (r == 0) {

			set.add(Integer.parseInt(now));

			return;
		}

		for (int i = depth; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				backTracking(depth + 1, n, r - 1, now + arr[i], arr, visited);
				backTracking(depth + 1, n, r - 1, arr[i] + now, arr, visited);
				visited[i] = false;
			}
		}
	}

	public static boolean isPrime(int num) {
		if (num == 0 || num == 1)
			return false;

		int lim = (int) Math.sqrt(num);

		for (int i = 2; i <= lim; i++)
			if (num % i == 0)
				return false;

		return true;
	}

}
