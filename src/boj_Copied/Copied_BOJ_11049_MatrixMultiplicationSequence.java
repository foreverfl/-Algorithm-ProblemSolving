package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_11049_MatrixMultiplicationSequence {

	static int N;
	static int r, c;
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][2];
		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map[i][0] = r;
			map[i][1] = c;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					dp[i][j] = 0;
				else
					dp[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int j = 1; j < N; j++) {
			for (int k = 0; k + j < N; k++) {
				calculate(k, k + j);
			}
		}

		System.out.println(dp[0][N - 1]);
	}

	public static void calculate(int start, int end) {
		for (int i = start; i < end; i++) {
			// A * B => a * b b * b b * c
			int a = dp[start][i];
			int b = dp[i + 1][end];

			int c = map[start][0];
			int d = map[i][1];
			int e = map[end][1];

			int before_part = a + b;
			int new_part = c * d * e;

			int cost = before_part + new_part;
			int compared = dp[start][end];
			dp[start][end] = Math.min(compared, cost);
		}

	}

}

// reference: https://namhandong.tistory.com/206