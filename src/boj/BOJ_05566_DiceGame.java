package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_05566_DiceGame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] map = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}

		int ans = 0;
		int now = 1;
		while (M-- > 0) {
			++ans;
			int dice = Integer.parseInt(br.readLine());
			now += dice;
			if (now >= N)
				break;

			now += map[now];

			if (now <= 0) {
				now = 1;
			}

			if (now >= N)
				break;
		}

		System.out.println(ans);

	}
}
