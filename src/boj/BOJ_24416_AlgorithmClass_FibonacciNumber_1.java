package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_24416_AlgorithmClass_FibonacciNumber_1 {

	private static int[] dp;
	private static int cnt_1, cnt_2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		fib_recursion(n);
		fib_dp(n);
		sb.append(cnt_1 + " " + cnt_2);
		System.out.println(sb.toString());
	}

	private static int fib_recursion(int n) {

		if (n == 1 || n == 2) {
			cnt_1++;
			return 1; // 코드 1
		} else {
			return (fib_recursion(n - 1) + fib_recursion(n - 2));
		}

	}

	private static int fib_dp(int n) {
		dp[1] = dp[2] - 1;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2]; // 코드 2
			cnt_2++;
		}

		return dp[n];
	}

}
