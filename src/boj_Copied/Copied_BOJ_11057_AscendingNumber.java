package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_11057_AscendingNumber {

	static final int mod = 10007;
	static int dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][10];
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) {
					dp[i][j] += dp[i - 1][k];
					dp[i][j] %= mod;
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[N][i];
		}
		
		System.out.println(sum % mod);
	}
}

// reference: https://sundries-in-myidea.tistory.com/77