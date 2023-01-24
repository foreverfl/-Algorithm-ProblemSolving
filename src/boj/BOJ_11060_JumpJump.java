package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11060_JumpJump {

	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println(0);
			System.exit(0);

		}

		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			if (dp[i] == 0 && i != 1)
				continue;

			for (int j = i + 1; j <= i + arr[i]; j++) {
				if (!isValid(j))
					break;

				if (dp[j] == 0)
					dp[j] = dp[i] + 1;
			}
		}

		if (dp[N] != 0) {
			System.out.println(dp[N]);
		} else {
			System.out.println(-1);
		}

	}

	private static boolean isValid(int num) {
		if (num >= 1 && num <= N) {
			return true;
		}

		return false;
	}

}
