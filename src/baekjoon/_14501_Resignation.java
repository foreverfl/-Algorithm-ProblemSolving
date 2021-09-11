package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _14501_Resignation {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] time = new int[N + 10];
		int[] profit = new int[N + 10];
		int[] dp = new int[N + 10]; // the accumulated profit
		// They declares arrays as large as 'N+10' because N+10 in case of 'the last day
		// + 5.'
		int max = 0;
		String[] str;
		for (int i = 1; i <= N; i++) {
			str = br.readLine().split(" ");
			time[i] = Integer.parseInt(str[0]); // Values of 1 column are saved in the 'time[i].
			profit[i] = Integer.parseInt(str[1]); // Values of 2 column are saved in the 'profit[i].
		}

		for (int i = 1; i <= N + 1; i++) {
			dp[i] = Math.max(dp[i], max); // It saves maximum profit in the 'dp[i].'
			dp[time[i] + i] = Math.max(dp[time[i] + i], profit[i] + dp[i]); // It calculates a profit gained when a
																			// counseling is over.
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
