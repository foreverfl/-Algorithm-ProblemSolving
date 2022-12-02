package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_09356_Skill {

	private static final int mod = 1000000007;
	private static long[][] dp = new long[10][100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 10; i++) {
			dp[i][1] = 1;
		}

		for (int digit = 0; digit <= 9; digit++) {
			for (int len = 2; len <= 100000; len++) {
				for (int x = 0; x <= digit; x++) {
					dp[digit][len] += dp[x][len - 1];
				}
				dp[digit][len] %= mod;
			}
		}

		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 15; j++) {
				System.out.printf("%7d ", dp[i][j]);
			}
			System.out.println();
		}

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			long ans = 0;
			for (int i = 0; i <= 9; i++) {
				ans += dp[i][N];
			}
			sb.append(ans % mod).append('\n');
		}

		System.out.println(sb.toString());
	}

}
