package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_09095_Adding1s2sand3s {

	static int dp[] = new int[11];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		// initialization
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i <= 10; i++) {
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
		}

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append('\n');
		}

		System.out.println(sb);

	}

}

// reference: https://fbtmdwhd33.tistory.com/73