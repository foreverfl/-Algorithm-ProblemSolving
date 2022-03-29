package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_02589_TreasureIsland {

	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					visited = new boolean[N][M];
					int val = bfs(i, j);
					result = Math.max(result, val);
				}
			}
		}

		System.out.println(result);

	}

	private static int bfs(int x, int y) {
		Queue<coordinate> queue = new LinkedList<>();
		int val = 0;
		visited[x][y] = true;
		queue.add(new coordinate(x, y, 0));

		while (!queue.isEmpty()) {

			coordinate tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (!visited[nx][ny] && map[nx][ny] == 'L') {
						visited[nx][ny] = true;
						queue.add(new coordinate(nx, ny, tmp.cnt + 1));

						val = Math.max(val, tmp.cnt + 1);
					}
				}
			}
		}

		return val;
	}

	public static class coordinate {
		int x;
		int y;
		int cnt;

		public coordinate(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}

// reference: https://ukyonge.tistory.com/125
