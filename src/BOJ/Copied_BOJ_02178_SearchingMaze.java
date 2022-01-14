package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_02178_SearchingMaze {

	static int[][] map;
	static int N;
	static int M;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 }; // x - up / down 
	static int[] dy = { 0, 0, -1, 1 }; // y - left / right

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0'; // Input the value as an integer type.
			}
		}

		visited = new boolean[N][M];
		visited[0][0] = true; // starting point
		bfs(0, 0);
		System.out.println(map[N - 1][M - 1]);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
					continue;
				if (visited[nextX][nextY] || map[nextX][nextY] == 0)
					continue;

				q.add(new int[] { nextX, nextY });
				map[nextX][nextY] = map[nowX][nowY] + 1; // adding the '1' to the last value
				visited[nextX][nextY] = true;
			}
		}
	}
}

// reference: https://wiselog.tistory.com/163