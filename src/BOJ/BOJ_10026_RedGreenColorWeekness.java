package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10026_RedGreenColorWeekness {

	static char map[][];
	static boolean visited[][];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int N, cnt, cnt_problem;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false) {
					cnt++;
				}
				dfs(i, j);
			}
		}

		visited = new boolean[N][N]; // initialization as not visited

		// person who can't distinguish the 'G' and the 'R'.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'G')
					map[i][j] = 'R';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false) {
					cnt_problem++;
				}
				dfs(i, j);
			}
		}

		System.out.println(cnt + " " + cnt_problem);
	}

	private static void dfs(int x, int y) {

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (map[x][y] == map[nx][ny] && visited[nx][ny] == false) { // Without this, stack overflow occurs.
					dfs(nx, ny);
				}
			}
		}

	}

}
