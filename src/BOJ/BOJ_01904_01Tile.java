package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01904_01Tile {

	static final long mod = 15746;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] dp = new long[N + 3];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] % mod + dp[i - 2] % mod;
		}

		long result = dp[N] % mod;

		System.out.println(result);

	}

}
