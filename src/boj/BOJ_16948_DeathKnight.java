package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16948_DeathKnight {

	static class Coordinate {
		int x;
		int y;
		int cnt;

		Coordinate(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int[][] map;
	static int[] dx = { -2, -2, +0, +0, +2, +2 };
	static int[] dy = { -1, +1, -2, +2, -1, +1 };
	static boolean[][] visited;
	static int N;
	static int r_1, c_1, r_2, c_2;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		st = new StringTokenizer(br.readLine());
		r_1 = Integer.parseInt(st.nextToken());
		c_1 = Integer.parseInt(st.nextToken());
		r_2 = Integer.parseInt(st.nextToken());
		c_2 = Integer.parseInt(st.nextToken());

		bfs(r_1, c_1);

		if (min == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(min);

	}

	private static void bfs(int x, int y) {
		visited[x][y] = true;

		Queue<Coordinate> queue = new LinkedList<>();
		queue.add(new Coordinate(r_1, c_1, 0));

		while (!queue.isEmpty()) {
			Coordinate nxt = queue.poll();

			if (nxt.x == r_2 && nxt.y == c_2) {
				min = Math.min(min, nxt.cnt);
				return;
			}

			for (int i = 0; i < 6; i++) {
				int nx = nxt.x + dx[i];
				int ny = nxt.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if (!visited[nx][ny]) {
						queue.add(new Coordinate(nx, ny, nxt.cnt + 1));
						visited[nx][ny] = true;
					}
				}
			}
		}

	}

}
