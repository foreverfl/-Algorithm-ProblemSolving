package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_01486_Hiking {

	static class Point implements Comparable<Point> {
		int x, y, time;

		public Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Point o) {
			return time - o.time;
		}
	}

	static final int INF = 1000000000;
	static int[][] map = new int[26][26];
	static int[][][][] dist = new int[26][26][26][26];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int N, M, T, D;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++)
				for (int k = 1; k <= N; k++)
					for (int l = 1; l <= M; l++)
						dist[i][j][k][l] = INF;
			

		for (int i = 1; i <= N; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				char ch = str[j - 1];

				if (ch >= 'A' && ch <= 'Z')
					map[i][j] = ch - 65;
				else if (ch >= 'a' && ch <= 'z')
					map[i][j] = ch - 71;

			}
		}

		// making the array of shortest path.
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++)
				dijkstra(i, j);

		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++)
				if (dist[1][1][i][j] + dist[i][j][1][1] <= D) // Sejun has to come back.
					max = Math.max(max, map[i][j]);

		System.out.println(max);

	}

	private static void dijkstra(int x, int y) {

		Queue<Point> queue = new PriorityQueue<>();
		dist[x][y][x][y] = 0;
		queue.add(new Point(x, y, 0));

		while (!queue.isEmpty()) {
			Point current = queue.poll();

			int x_current = current.x;
			int y_current = current.y;
			int time = current.time;

			if (dist[x_current][y_current][x][y] < time)
				continue;

			for (int i = 0; i < 4; i++) {
				int nx = x_current + dx[i];
				int ny = y_current + dy[i];
				int nTime;

				if (nx < 1 || ny < 1 || nx > N || ny > M)
					continue;

				if (Math.abs(map[x_current][y_current] - map[nx][ny]) > T)
					continue;

				if (map[nx][ny] <= map[x_current][y_current])
					nTime = time + 1;
				else
					nTime = (int) Math.pow((map[nx][ny] - map[x_current][y_current]), 2) + time;

				if (dist[nx][ny][x][y] > nTime && nTime <= D) { // the core of dijkstra(renewing an existing path as
																// small one)
					dist[nx][ny][x][y] = nTime;
					queue.add(new Point(nx, ny, nTime));
				}
			}
		}
	}

}

// reference: https://dev-gorany.tistory.com/142
