package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_10211_MaximumSubarray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] dp = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int max = arr[0];
			dp[0] = arr[0];
			for (int i = 1; i < N; i++) {
				if (dp[i - 1] < 0)
					dp[i - 1] = 0;
				dp[i] = dp[i - 1] + arr[i];
				max = Math.max(max, dp[i]);
			}
			sb.append(max).append('\n');
		}

		System.out.print(sb.toString());
	}

}

// reference: https://loosie.tistory.com/232