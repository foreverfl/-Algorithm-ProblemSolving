package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_1003_FibonacciFunction {

	static Integer[][] dp = new Integer[41][2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		dp[0][0] = 1; // N=0 → count '0'
		dp[0][1] = 0; // N=0 → count '1'
		dp[1][0] = 0; // N=1 → count '0'
		dp[1][1] = 1; // N=1 → count '1'

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			sb.append(dp[N][0] + " " + dp[N][1]).append('\n');
		}
		System.out.println(sb.toString());

	}

	private static Integer[] fibonacci(int N) {
		if (dp[N][0] == null || dp[N][1] == null) {
			dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
			dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
		}
		return dp[N];
	}

}

// reference: https://st-lab.tistory.com/124