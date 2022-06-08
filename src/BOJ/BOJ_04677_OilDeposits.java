package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_04677_OilDeposits {

	static char[][] map;
	static boolean[][] visited;
	static int dx[] = { +0, +1, +1, +1, +0, -1, -1, -1 }; // clock direction from the right
	static int dy[] = { +1, +1, +0, -1, -1, -1, +0, +1 };
	static int m, n;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			if (m == 0)
				break;

			map = new char[m][n];
			visited = new boolean[m][n];

			for (int i = 0; i < m; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '@' && !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}

				}
			}

			sb.append(cnt).append('\n');

			// init
			cnt = 0;

		}

		System.out.println(sb.toString());
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= m || ny >= n)
				continue;

			if (visited[nx][ny])
				continue;

			if (map[nx][ny] == '@')
				dfs(nx, ny);
		}
	}

}
