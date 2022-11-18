package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_17144_GoodByeFineDust {

	private static int R, C, T;
	private static int[][] map;
	// 북동남서
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (T-- > 0) {
			// 미세먼지 확산
			int[][] tmp = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					int x = i;
					int y = j;
					if (map[x][y] == -1) {
						tmp[x][y] = map[x][y];
					}

					if (map[x][y] >= 1) {
						// 확산
						int cnt = 0;
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];

							if (!isValid(nx, ny))
								continue;

							if (map[nx][ny] != -1) {
								cnt++;
								tmp[nx][ny] += map[x][y] / 5;
							}
						}
						// 남음
						tmp[x][y] += (map[x][y] - ((map[x][y] / 5) * cnt));
					}

				}
			}

			// 깊은 복사
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = tmp[i][j];
				}
			}
			print();

			int check = 0;
			for (int i = 0; i < R; i++) {
				// 공기청정기 작동 위
				if (check == 0) {
					if (map[i][0] == -1) {
						cleanUp(i, 0);
						check = 1;
					}

				}

				// 공기청정기 작동 아래
				if (check == 1) {

					cleanDown(i + 1, 0);
					break;

				}
			}

		}
		print();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0) {
					ans += map[i][j];
				}
			}
		}

		System.out.println(ans + 2);

	}

	private static boolean isValid(int x, int y) {
		if (x < 0 || x >= R || y < 0 || y >= C) {
			return false;
		}

		return true;
	}

	// 화살표부터 꼬리까지
	private static void cleanUp(int x, int y) {
		// ↓
		for (int i = x - 2; i > 0; i--) {
			map[i + 1][0] = map[i][0];
		}

		// ←
		for (int i = 1; i < C; i++) {
			map[0][i - 1] = map[0][i];
		}

		// ↑
		for (int i = 1; i < x + 1; i++) {
			map[i - 1][C - 1] = map[i][C - 1];
		}

		// →
		for (int i = C - 2; i > 0; i--) {
			map[x][i + 1] = map[x][i];
		}

		// 마지막에는 값을 0으로 만들어줌
		map[x][y + 1] = 0;

	}

	// 화살표부터 꼬리까지
	private static void cleanDown(int x, int y) {
		// ↑
		for (int i = x + 2; i < R; i++) {
			map[i - 1][0] = map[i][0];
		}

		// ←
		for (int i = 1; i < C; i++) {
			map[R - 1][i - 1] = map[R - 1][i];
		}

		// ↓
		for (int i = R - 1; i > x - 1; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}

		// →
		for (int i = C - 1; i > 1; i--) {
			map[x][i] = map[x][i - 1];
		}

		// 마지막에는 값을 0으로 만들어줌
		map[x][y + 1] = 0;

	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.printf("%2d ", map[i][j]);
			}
			System.out.println();
		}
		System.out.println("===============================");
	}

}
