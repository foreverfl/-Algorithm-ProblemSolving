package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_03190_zmija {
	private static int n, d, k, l;
	private static int[][] map;
	private static Map<Integer, String> moveInfo;
	private static int[] dx = { 1, 0, -1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		map = new int[n][n];
		moveInfo = new HashMap<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			map[a][b] = 1;
		}

		l = Integer.parseInt(br.readLine());
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String direction = st.nextToken();
			moveInfo.put(time, direction);
		}

		solve();
	}

	private static void solve() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		int time = 0;
		int px = 0;
		int py = 0;

		while (true) {
			int nx = px + dx[d];
			int ny = py + dy[d];
			time++;

			// 벽 부딪힘
			if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1) {
				break;
			}

			// 몸통 부딪힘
			if (queue.contains(ny * n + nx)) {
				break;
			}

			// 안 부딪히면 뱀 이동시작
			if (map[ny][nx] == 1) {
				map[ny][nx] = 0;
				queue.add(ny * n + nx);
			} else {
				queue.add(ny * n + nx);
				queue.poll();
			}

			// 방향 전환
			if (moveInfo.containsKey(time)) {
				String data = moveInfo.get(time);
				if (data.equals("D")) {
					d += 1;
					if (d == 4)
						d = 0;
				} else {
					d -= 1;
					if (d == -1)
						d = 3;
				}
			}
			px = nx;
			py = ny;
		}
		
		System.out.println(time);
	}

}

// reference: https://loosie.tistory.com/269