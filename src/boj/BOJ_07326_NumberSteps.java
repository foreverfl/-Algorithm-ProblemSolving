package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_07326_NumberSteps {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int ans = 0;
			if (x == y) {
				if (x % 2 == 0) {
					ans = x * 2;
				} else {
					ans = x * 2 - 1;
				}
			} else if (x - y == 2) {
				if (x % 2 == 0) {
					ans = x + y;
				} else {
					ans = x + y - 1;
				}
			} else {
				ans = -1;
			}

			if (ans == -1) {
				sb.append("No Number").append('\n');
			} else {
				sb.append(ans).append('\n');
			}

		}

		System.out.println(sb.toString());
	}
}
