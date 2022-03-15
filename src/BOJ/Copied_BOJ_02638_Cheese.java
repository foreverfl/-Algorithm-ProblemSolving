package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_02638_Cheese {

	static int N, M, count, answer;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// internal air -> 0
	// cheese -> 1
	// external air -> 2
	// melt cheese -> 3

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		count = 0;
		answer = 0;

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;

				if (value == 1)
					count++;
			}
		}

		checkExternalAir(0, 0);

		while (count != 0) {
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !visited[i][j])
						dfs(i, j);
				}
			}

			visited = new boolean[N][M];
			checkExternalAir(0, 0);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = map[i][j] == 3 ? 2 : map[i][j];
				}
			}

			answer++;
		}

		System.out.println(answer);
	}

	// 외부와 접촉한 공기 '2'로 표시
	static void checkExternalAir(int x, int y) {
		visited[x][y] = true;
		map[x][y] = 2;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			if (visited[nx][ny] || map[nx][ny] == 1)
				continue;

			map[nx][ny] = 2;
			checkExternalAir(nx, ny);
		}
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;

		if (map[x][y] == 1 && isMelt(x, y)) {
			--count;
			map[x][y] = 3; // 녹은 치즈는 3으로 바꿔준다 (0으로 바꾸면 언제 녹았는지 구분 불가)
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			if (visited[nx][ny] || map[nx][ny] == 0)
				continue;

			dfs(nx, ny);
		}
	}

	static boolean isMelt(int x, int y) {
		int air = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			if (map[nx][ny] == 2)
				++air;
		}

		return air >= 2;
	}
}

// reference: https://velog.io/@leeinae/Algorithm-%EB%B0%B1%EC%A4%80-2638-%EC%B9%98%EC%A6%88-java