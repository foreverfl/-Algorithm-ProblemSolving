package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_02573_Iceberg {

	static int N;
	static int M;
	static int[][] map;
	static int[][] visited;
	static int[][] melt;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		melt = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solution();
	}

	private static void solution() {
		int year = 0;

		while (true) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j] == 0 && map[i][j] != 0) {
						dfs(i, j);
						count++;
					}
				}
			}

			if (count == 0) {
				System.out.println(0);
				break;
			} else if (count >= 2) {
				System.out.println(year);
				break;
			}

			melting();
			year++;
		}
	}

	private static void dfs(int x, int y) {
		visited[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (map[nx][ny] == 0) 
					melt[x][y]++; // how much is the iceberg melt?

				if (visited[nx][ny] == 0 && map[nx][ny] != 0)
					dfs(nx, ny);
			}
		}
	}

	private static void melting() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] -= melt[i][j];

				if (map[i][j] < 0) // The negative number is not available.
					map[i][j] = 0;

				visited[i][j] = 0; // initialization
				melt[i][j] = 0; // initialization
			}
		}
	}
}

// reference: https://bcp0109.tistory.com/11