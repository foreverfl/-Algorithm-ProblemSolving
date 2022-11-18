package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02979_Parking {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		boolean[][] arr = new boolean[3 + 1][100 + 1];

		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			for (int j = start; j < end; j++) {
				arr[i][j] = true;
			}
		}

		int ans = 0;
		for (int i = 1; i <= 100; i++) {
			int cnt = 0;
			for (int j = 1; j <= 3; j++) {
				if (arr[j][i]) {
					cnt++;
				}
			}
			if (cnt == 1) {
				ans += A;
			} else if (cnt == 2) {
				ans += (B * 2);
			} else if (cnt == 3) {
				ans += (C * 3);
			}
		}

		System.out.println(ans);

	}

}
