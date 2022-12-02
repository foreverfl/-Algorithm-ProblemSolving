package programmers;

public class Solving_Programmers_64065_TheFirstDiscovery {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 3, 3, 0 }, { 3, 2, 2, 3 }, { 0, 3, 2, 0 }, { 0, 3, 3, 3 } }));

	}

	private static int N, M;
	private static int dx[] = { 0, 0, -1, 1 };
	private static int dy[] = { -1, 1, 0, 0 };
	private static int[][] map;

	public static int solution(int[][] clockHands) {
		N = clockHands.length;
		M = clockHands[0].length;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = clockHands[i][j];
			}
		}

//		print();

		int answer = 0;
		while (true) {
			if (isOver()) {
				break;
			}

			// 주변에 3이 가장 많은 부분 찾기
			int[][] cnt = new int[N][M];
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					cnt[i][j] = countThree(i, j);
					max = Math.max(max, cnt[i][j]);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cnt[i][j] == max) {
						rotate(i, j);
					}
				}
			}

			answer++;

//			print();
		}

		return answer;
	}

	private static boolean isValid(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M)
			return true;

		return false;

	}

	private static int countThree(int x, int y) {
		int res = 0;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!isValid(nx, ny))
				continue;

			if (map[nx][ny] == 3)
				res++;
		}

		return res;
	}

	private static void rotate(int x, int y) {
		if (map[x][y] == 0) {
			map[x][y] = 1;
		} else if (map[x][y] == 1) {
			map[x][y] = 2;
		} else if (map[x][y] == 2) {
			map[x][y] = 3;
		} else if (map[x][y] == 3) {
			map[x][y] = 0;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!isValid(nx, ny))
				continue;

			if (map[nx][ny] == 0) {
				map[nx][ny] = 1;
			} else if (map[nx][ny] == 1) {
				map[nx][ny] = 2;
			} else if (map[nx][ny] == 2) {
				map[nx][ny] = 3;
			} else if (map[nx][ny] == 3) {
				map[nx][ny] = 0;
			}

		}
	}

	private static boolean isOver() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0)
					return false;
			}
		}

		return true;
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("======================");
	}

}
