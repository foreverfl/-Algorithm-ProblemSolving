package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solving_BOJ_14943_FleeMarket {

	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long ans = 0;
		while (true) {
			long check = 0;
			for (int i = 0; i < N; i++) {
				check += arr[i];
			}
			if (check == 0)
				break;

			int max_idx = 0;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				max = Math.max(max, Math.abs(arr[i]));
				if (max == arr[i])
					max_idx = i;
			}

			int next_left = max_idx;
			boolean left_possible = false;
			int next_right = max_idx;
			boolean right_possible = false;

			while (true) {
				next_left--;
				if (!isPossible(next_left)) {
					left_possible = false;
					break;
				}

				if (arr[next_left] != 0) {
					left_possible = true;
					break;
				}
			}

			while (true) {
				next_right++;
				if (!isPossible(next_right)) {
					right_possible = false;
					break;
				}

				if (arr[next_right] != 0) {
					right_possible = true;
					break;
				}
			}

			int tmp = 0;
			if (left_possible) {
				ans += (Math.abs(arr[max_idx] - arr[next_left]));
				
			}

			if (right_possible) {

			}

		}

		System.out.println(ans);

	}

	private static boolean isPossible(int num) {
		if (num >= 0 && num < N)
			return true;

		return false;
	}

}
