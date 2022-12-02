package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solving_BOJ_25821_PalindromicPrimes {

	private static int[] primes = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37 };
	private static Set<Long> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long L = Long.parseLong(st.nextToken());
		long H = Long.parseLong(st.nextToken());

		int ans = 0;
		for (long i = L; i <= H; i++) {
			if (isPalindrome(i)) {
				for (int j = 0; j < primes.length; j++) {
					if (miller(i, primes[j])) {
						set.add(i);
					}
				}

			}
		}

		System.out.println(set.toString());

	}

	private static boolean isPalindrome(long num) {
		StringBuilder sb = new StringBuilder();
		sb.append(num);

		String str = sb.toString();
		String reversed = sb.reverse().toString();

		if (str.equals(reversed))
			return true;
		return false;

	}

	// n이 소수라면 true이다.
	// a == 2 || a == 7 || a == 61이면 만족하면 int 범위에서 소수를 찾고
	// 1<=a<=37이면 long 범위에서의 소수를 찾는다.
	private static boolean miller(long n, long a) {
		if (a % n == 0)
			return false;
		long k = n - 1;
		while (true) { //
			long temp = power(a, k, n);
			if (temp == n - 1)
				return true; // a^k = -1 (mod n)
			if (k % 2 != 0) //
				return (temp == 1 || temp == n - 1);
			k /= 2;
		}
	}

	private static long power(long x, long y, long mod) {
		long res = 1;
		x %= mod;
		while (y != 0) { //
			if (y % 2 != 0) //
				res = (res * x) % mod;
			y /= 2;
			x = (x * x) % mod;
		}
		return res;
	}
}
