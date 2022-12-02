package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_1844_ShortestDistanceOfGame {

	public static void main(String[] args) {
//		System.out.println(solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 },
//				{ 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 } }));
		System.out.println(solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 },
				{ 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1 } }));
	}

	private static class Node {
		int x;
		int y;
		int distance;

		public Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", distance=" + distance + "]";
		}

	}

	private static int N, M, ans = Integer.MAX_VALUE;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { -1, 1, 0, 0 };

	public static int solution(int[][] maps) {
		N = maps.length;
		M = maps[0].length;

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = maps[i][j];
			}
		}

		visited = new boolean[N][M];

		bfs();

		ans = (ans == Integer.MAX_VALUE) ? -1 : ans;
		return ans;
	}

	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0, 1));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();
			if (now.x == N - 1 && now.y == M - 1) {
				ans = Math.min(ans, now.distance);
			}

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (!isValid(nx, ny))
					continue;

				if (visited[nx][ny])
					continue;

				if (map[nx][ny] == 1) {
					queue.offer(new Node(nx, ny, now.distance + 1));
					visited[nx][ny] = true;
				}

			}
		}
	}

	private static boolean isValid(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M)
			return true;

		return false;
	}

}
