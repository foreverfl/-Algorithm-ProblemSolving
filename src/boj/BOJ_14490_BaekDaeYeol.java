package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14490_BaekDaeYeol {

	static boolean prime[];
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] str_arr = str.split(":");

		n = Integer.parseInt(str_arr[0]);
		m = Integer.parseInt(str_arr[1]);

		int max = Integer.MIN_VALUE;
		if (n >= m)
			max = n;
		else
			max = m;

		prime = new boolean[max + 1];

		findPrime(max);

		divide();

		System.out.println(n + ":" + m);
	}

	private static void findPrime(int a) {

		prime[0] = prime[1] = true; // prime is the 'false'.

		for (int i = 2; i * i <= a; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= a; j += i)
					prime[j] = true;
			}
		}

	}

	private static void divide() {
		for (int i = 0; i < prime.length; i++) {
			if (!prime[i]) {
				if (n % i == 0 && m % i == 0) {
					n = n / i;
					m = m / i;
					i = -1;
				}
			}
		}
		return;
	}

}
