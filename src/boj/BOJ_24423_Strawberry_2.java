package boj;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_24423_Strawberry_2 {

	private static int[] dx = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
	private static int[] dy = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		Map<Point, Integer> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			Point now = new Point(x, y);
			if (map.containsKey(now)) {
				map.put(now, map.get(now) + 1);
			} else {
				map.put(now, 1);
			}
		}

		int ans = Integer.MIN_VALUE;
		for (int i = 2; i <= H - 1; i++) {
			for (int j = 2; j <= W - 1; j++) {
				int cnt = 0;
				for (int k = 0; k < 9; k++) {
					Point now = new Point(j + dx[k], i + dy[k]);
					if (map.containsKey(now)) {
						cnt += map.get(now);
					}
				}
				ans = Math.max(ans, cnt);
			}
		}

		System.out.println(ans);
	}

}
