package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solving_BOJ_06556_PathsOnAGrid {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) {
			System.gc();
			String str = br.readLine();

			if (str.equals("0 0"))
				break;

			st = new StringTokenizer(str);
			int H = Integer.parseInt(st.nextToken()) + 1;
			int W = Integer.parseInt(st.nextToken()) + 1;
			int[][] dp = new int[H][W];
			for (int i = 0; i < H; i++) {
				dp[i][0] = 1;
			}

			for (int i = 0; i < W; i++) {
				dp[0][i] = 1;
			}

			for (int i = 1; i < H; i++) {
				for (int j = 1; j < W; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}

			sb.append(dp[H - 1][W - 1]).append('\n');

		}

		System.out.println(sb.toString());
	}

}
