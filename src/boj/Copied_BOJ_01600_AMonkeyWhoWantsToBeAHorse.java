package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_01600_AMonkeyWhoWantsToBeAHorse {

	static class Node {
		int x, y, k, c;

		Node(int x, int y, int k, int c) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.c = c;
		}
	}

	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	// knight move
	static int[] dx_k = { -1, -2, -2, -1, +1, +2, +2, +1 }; // y
	static int[] dy_k = { -2, -1, +1, +2, +2, +1, -1, -2 }; // x
	static int K, W, H;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		visited = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

		ans = (ans == Integer.MAX_VALUE) ? -1 : ans;

		System.out.print(ans);
	}

	public static void bfs() {

		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0, K, 0));
		visited[0][0][K] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			if (now.x == H - 1 && now.y == W - 1) {
				ans = Math.min(ans, now.c);
			}

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (isRange(nx, ny) && !visited[nx][ny][now.k]) {
					if (map[nx][ny] == 0) {
						visited[nx][ny][now.k] = true;
						queue.offer(new Node(nx, ny, now.k, now.c + 1));
					}
				}
			}

			if (now.k > 0) {
				for (int i = 0; i < 8; i++) {
					int nx = now.x + dx_k[i];
					int ny = now.y + dy_k[i];

					if (isRange(nx, ny) && !visited[nx][ny][now.k - 1]) {

						if (map[nx][ny] == 0) {
							visited[nx][ny][now.k - 1] = true;
							queue.offer(new Node(nx, ny, now.k - 1, now.c + 1));
						}
					}
				}
			}

		}
	}

	public static boolean isRange(int x, int y) {
		if (x >= 0 && x < H && y >= 0 && y < W)
			return true;

		return false;
	}

}

// reference: https://moonsbeen.tistory.com/181
