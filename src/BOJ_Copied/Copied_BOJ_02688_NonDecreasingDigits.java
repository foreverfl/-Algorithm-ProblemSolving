package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_02688_NonDecreasingDigits {

	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			dp = new long[n + 1][10]; // array[place][the first number]

			// init
			for (int i = 0; i <= n; i++) {
				dp[i][0] = 1;
			}

			for (int i = 0; i < 10; i++) {
				dp[1][i] = 1;
			}

			long sum = 0;
			for (int i = 2; i <= n; i++) {
				for (int j = 1; j < 10; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}

			for (long num : dp[n]) {
				sum += num;
			}
			sb.append(sum).append('\n');
		}

		System.out.print(sb.toString());
	}

}

// reference: https://loosie.tistory.com/215