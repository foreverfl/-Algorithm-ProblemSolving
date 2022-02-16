package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_14939_TurningOff {
	static int answer = Integer.MAX_VALUE;
	static int[][] delta = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visited = new boolean[10][10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[][] map = new boolean[10][10];

		for (int i = 0; i < 10; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < 10; j++) {
				if (line[j] == 'O') {
					map[i][j] = true;
				}
			}
		}

		for (int i = 0; i < 1024; i++) {
			copy(map);
			int count = 0;

			for (int j = 0; j < 10; j++) {
				if (((1 << j) & i) != 0) { // The '1 << j' means a quotient when a number is divided by 2.
					on(0, j);
					count++;
				}
			}

			for (int n = 0; n < 9; n++) {
				for (int m = 0; m < 10; m++) {
					if (visited[n][m]) {
						on(n + 1, m);
						count++;
					}
				}
			}

			if (checkLight()) {
				answer = Math.min(answer, count);
			}
		}

		if (answer < Integer.MAX_VALUE) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}
	}

	static boolean checkLight() {
		for (int i = 0; i < 10; i++) {
			if (visited[9][i]) {
				return false;
			}
		}
		return true;
	}

	static void copy(boolean[][] map) {
		for (int i = 0; i < 10; i++) {
			visited[i] = map[i].clone();
		}
	}

	static void on(int x, int y) {
		for (int i = 0; i < 5; i++) {
			int nX = x + delta[i][0];
			int nY = y + delta[i][1];
			if (isIn(nX, nY)) {
				visited[nX][nY] = !visited[nX][nY];
			}
		}
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x <= 9 && 0 <= y && y <= 9) {
			return true;
		}
		return false;
	}
}

// reference: https://nodingco.tistory.com/16