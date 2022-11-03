package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_02146_BuildingBridge {
	private static int[][] map;
	private static boolean[][] visited;
	private static int N;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, -1, 0, 1 };
	private static int landNum = 2;
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					makeLand(i, j);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= 2) {
					visited = new boolean[N][N];
					bfs(i, j);
				}
			}
		}

		System.out.println(answer);
	}

	private static void makeLand(int x, int y) {

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y, 0));
		visited[x][y] = true;
		map[x][y] = landNum;

		while (!queue.isEmpty()) {
			Point point = queue.poll();
			for (int i = 0; i < 4; i++) {

				int nx = point.x + dx[i];
				int ny = point.y + dy[i];

				if ((nx >= 0 && nx < N && ny >= 0 && ny < N) && !visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					map[nx][ny] = landNum;
					queue.offer(new Point(nx, ny, 0));
				}
			}
		}
		landNum++;
	}

	private static void bfs(int x, int y) {

		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(x, y, 0));
		int currentLandNum = map[x][y];
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Point point = queue.poll();
			for (int i = 0; i < 4; i++) {

				int nx = point.x + dx[i];
				int ny = point.y + dy[i];

				if ((nx >= 0 && nx < N && ny >= 0 && ny < N) && !visited[nx][ny] && map[nx][ny] != currentLandNum) {
					visited[nx][ny] = true;
					if (map[nx][ny] == 0) {
						queue.offer(new Point(nx, ny, point.cnt + 1));
					} else {
						answer = Math.min(answer, point.cnt);
					}
				}
			}
		}
	}

	static class Point {
		int x;
		int y;
		int cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}

// reference: https://youngest-programming.tistory.com/503
