package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01699_SumOfSquareNumbers {

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] dp = new int[100001];

		// initializing as maximum values
		for (int i = 1; i <= n; i++) {
			dp[i] = i;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				if (dp[i] > dp[i - (j * j)] + 1) {
					dp[i] = dp[i - (j * j)] + 1;
				}
			}
		}

		System.out.println(dp[n]);
	}

}

// reference: https://maivve.tistory.com/199
