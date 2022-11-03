package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Copied_BOJ_02631_Lining {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			dp[i] = 1;

			for (int j = 1; j < i; j++) {
				if (arr[i] > arr[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		Arrays.sort(dp);
		System.out.println(N - dp[N]);
	}

}

// reference: https://mygumi.tistory.com/276
// reference: https://dundung.tistory.com/49