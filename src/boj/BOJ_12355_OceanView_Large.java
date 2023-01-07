package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12355_OceanView_Large {

	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			dp = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			int LIS = 0;

			for (int j = 0; j < N; j++) {
				int idx = binarySearch(arr[j], 0, LIS, LIS + 1);

				if (idx == -1) {
					dp[LIS++] = arr[j];
				} else {
					dp[idx] = arr[j];
				}
			}
			int ans = N - LIS;
			sb.append("Case #" + i + ": " + ans).append('\n');
		}

		System.out.println(sb.toString());

	}

	private static int binarySearch(int num, int start, int end, int size) {
		int res = 0;
		while (start <= end) {
			int mid = (start + end) / 2;

			if (num <= dp[mid]) {
				res = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		if (start == size) {
			return -1;
		} else {
			return res;
		}
	}

}
