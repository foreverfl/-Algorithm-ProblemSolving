package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_23247_TEN {

	private static int[][] sum = new int[301][301];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		// 누적합 구하기
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int num = Integer.parseInt(st.nextToken());
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + num;
			}
		}

		int ans = 0;
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++)
				for (int k = 0; k <= 9; k++)
					for (int l = 0; l <= 9; l++)
						if ((k + 1) * (l + 1) <= 10 && (i + k) <= m && (j + l) <= n
								&& prefix_sum(i, j, i + k, j + l) == 10)
							ans++;

		System.out.println(ans);
	}

	private static int prefix_sum(int y1, int x1, int y2, int x2) {
		return sum[y2][x2] - sum[y2][x1 - 1] - sum[y1 - 1][x2] + sum[y1 - 1][x1 - 1];
	}

}

// reference: https://velog.io/@beclever/C-%EB%B0%B1%EC%A4%80-23247%EB%B2%88-Ten