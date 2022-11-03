package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02167_TwoDimensionalSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int K = Integer.parseInt(br.readLine());
		while (K-- > 0) {
			int[] start = new int[2];
			int[] end = new int[2];

			st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());

			int sum = 0;

			// 0 -> x
			// 1 -> y
			int initialization_y = start[1];
			while (start[0] <= end[0]) {
				while (start[1] <= end[1]) {
					sum += map[start[0]][start[1]];
					start[1]++;
				}
				start[0]++;
				start[1] = initialization_y;
			}

			sb.append(sum).append('\n');

			sum = 0;
		}

		System.out.println(sb.toString());
	}

}
