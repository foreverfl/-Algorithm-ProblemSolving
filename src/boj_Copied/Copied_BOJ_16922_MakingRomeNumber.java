package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_16922_MakingRomeNumber {

	static int N;
	static int[] arr = { 1, 5, 10, 50 };
	static int[] sum = new int[10001];
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		backTracking(0, 0, 0);

		System.out.println(ans);

	}

	public static void backTracking(int depth, int idx, int s) {
		if (depth == N) {
			if (sum[s] == 0) {
				sum[s] = 1;
				ans++;
			}
			return;
		}

		for (int i = idx; i < 4; i++) {
			backTracking(depth + 1, i, s + arr[i]);
		}
	}

}

// reference: https://superbono-2020.tistory.com/124
