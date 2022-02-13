package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01926_Drawing {

	static int n, m;
	static int[][] map;
	static boolean[][] checked;
	static int[] dX = { 0, 0, -1, 1 };
	static int[] dY = { 1, -1, 0, 0 };
	static int cnt;
	static int size;
	static int size_tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		checked = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!checked[i][j] && map[i][j] == 1) {
					size_tmp = 1;
					cnt++;
					dfs(i, j);
					size = size < size_tmp ? size_tmp : size;
				}
			}
		}

		System.out.println(cnt);
		System.out.println(size);

	}

	private static void dfs(int x, int y) {
		checked[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nX = x + dX[i];
			int nY = y + dY[i];

			if (nX >= 0 && nY >= 0 && nX < n && nY < m) {
				if (map[nX][nY] == 1 && checked[nX][nY] == false) {
					size_tmp++;
					dfs(nX, nY);
				}
			}

		}
	}

}
