package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17245_ServerRoom {
	private static int n;
	private static int[][] map = new int[1001][1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		long left = 0, right = 0, sum = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
				if (map[i][j] > right)
					right = map[i][j];
			}
		}

		while (left + 1 < right) {
			long mid = (left + right) / 2;
			long cnt = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cnt += mid > map[i][j] ? map[i][j] : mid;
				}
			}

			if (((double) cnt / sum) >= 0.5)
				right = mid;
			else
				left = mid;
		}

		System.out.println(right);

	}

}

// reference: https://2jinishappy.tistory.com/214