package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01987_Alphabet {

	static int R, C;
	static int[][] map;
	static boolean[] visited = new boolean[26];
	static int[] dX = { 0, 0, -1, 1 };
	static int[] dY = { -1, 1, 0, 0 };
	static int answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}

		dfs(0, 0, 0);

		System.out.println(answer);

	}

	private static void dfs(int x, int y, int count) {
		if (visited[map[x][y]]) { // If the 'map[x][y]' is already visited.
			answer = Math.max(answer, count);
			return;
		} else {
			visited[map[x][y]] = true;
			for (int i = 0; i < 4; i++) {
				int nX = x + dX[i];
				int nY = y + dY[i];

				if (nX >= 0 && nY >= 0 && nX < R && nY < C) {
					dfs(nX, nY, count + 1);
				}
			}

			visited[map[x][y]] = false;
		}

	}

}

// reference: https://1-7171771.tistory.com/61
