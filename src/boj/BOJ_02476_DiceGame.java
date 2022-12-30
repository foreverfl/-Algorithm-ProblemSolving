package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02476_DiceGame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int ans = Integer.MIN_VALUE;
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			int[] arr = new int[7];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				arr[Integer.parseInt(st.nextToken())]++;
			}
			ans = Math.max(ans, calc(arr));
		}

		System.out.println(ans);
	}

	private static int calc(int[] arr) {
		int maxCnt = -1;
		int common_2 = -1;
		int common_3 = -1;
		int max = -1;
		for (int i = 6; i >= 1; i--) {
			maxCnt = Math.max(maxCnt, arr[i]);
			if (common_2 == -1 && maxCnt == 2) {
				common_2 = i;
			} else if (common_3 == -1 && maxCnt == 3) {
				common_3 = i;
			}

			if (max == -1 && arr[i] != 0) {
				max = i;
			}
		}

		if (maxCnt == 3) {
			return 10000 + common_3 * 1000;
		} else if (maxCnt == 2) {
			return 1000 + common_2 * 100;
		} else {
			return max * 100;
		}
	}

}
