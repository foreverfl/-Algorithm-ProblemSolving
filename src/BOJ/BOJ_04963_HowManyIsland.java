package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_04963_HowManyIsland {
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	static int dX[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int dY[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			map = new int[h][w];
			visited = new boolean[h][w];
			cnt = 0;

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append('\n');
		}

		System.out.println(sb);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curY = queue.peek()[1];
			queue.poll();

			for (int i = 0; i < 8; i++) {
				int nX = curX + dX[i];
				int nY = curY + dY[i];

				if (nX >= 0 && nY >= 0 && nX < h && nY < w) {
					if (map[nX][nY] == 1 && !visited[nX][nY]) {
						queue.add(new int[] { nX, nY });
						visited[nX][nY] = true;
					}
				}
			}
		}
	}
}
