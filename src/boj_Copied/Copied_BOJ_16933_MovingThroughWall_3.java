package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_16933_MovingThroughWall_3 {

	static final int day = 0;
	static final int night = 1;

	static class Node {
		int x;
		int y;
		int cnt;
		int canBreak;
		int day;

		Node(int x, int y, int cnt, int canBreak, int day) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.canBreak = canBreak;
			this.day = day;
		}

	}

	static int[][] map;
	static boolean[][][][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N, M, K;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M][K + 1][2]; // x, y, K, day

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs();

		if (ans == 0)
			System.out.print(-1);
		else
			System.out.print(ans);
	}

	public static void bfs() {

		Queue<Node> queue = new LinkedList<>();

		queue.offer(new Node(0, 0, 1, 0, 0)); // including starting point and end point
		visited[0][0][0][0] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			if (now.x == N - 1 && now.y == M - 1) {
				ans = now.cnt;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (isRange(nx, ny)) {

					if (map[nx][ny] == 0) {
						if (now.day == day && !visited[nx][ny][now.canBreak][night]) {
							queue.offer(new Node(nx, ny, now.cnt + 1, now.canBreak, night));
							visited[nx][ny][now.canBreak][night] = true;

						} else if (now.day == night && !visited[nx][ny][now.canBreak][day]) {
							queue.offer(new Node(nx, ny, now.cnt + 1, now.canBreak, day));
							visited[nx][ny][now.canBreak][day] = true;
						}

					} else {
						if (now.canBreak < K && now.day == day && !visited[nx][ny][now.canBreak + 1][night]) {
							visited[nx][ny][now.canBreak + 1][night] = true;
							queue.offer(new Node(nx, ny, now.cnt + 1, now.canBreak + 1, night));

						} else if (now.canBreak < K && now.day == night && !visited[now.x][now.y][now.canBreak][day]) {
							visited[now.x][now.y][now.canBreak][day] = true;
							queue.offer(new Node(now.x, now.y, now.cnt + 1, now.canBreak, day));
						}
					}
				}
			}
		}
	}

	public static boolean isRange(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M)
			return true;

		return false;
	}

}

// reference: https://dding9code.tistory.com/21
