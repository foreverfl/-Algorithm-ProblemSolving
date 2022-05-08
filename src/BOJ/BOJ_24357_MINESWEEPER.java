package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24357_MINESWEEPER {

	static int[][] map;
	static boolean[][] visited;
	static int dx[] = { -1, +0, +1, -1, +1, -1, +0, +1 };
	static int dy[] = { -1, -1, -1, +0, +0, +1, +1, +1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[3][3];
		visited = new boolean[3][3];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[i][j] == 0) {
					check(i, j);
					visited = new boolean[3][3];
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void check(int x, int y) {
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
				if (map[nx][ny] == 9 && !visited[nx][ny]) {
					map[x][y]++;
					visited[nx][ny] = true;
				}
			}
		}

	}

}
