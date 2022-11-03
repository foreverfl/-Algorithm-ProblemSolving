package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Copied_BOJ_02210_JumpingNumberPanel {

	static String[][] map = new String[5][5];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = st.nextToken();
			}
		}

		String str = new String();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, 0, str);
			}
		}

		System.out.println(set.size());
	}

	private static void dfs(int x, int y, int depth, String str) {
		if (depth == 6) {
			set.add(str);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
				dfs(nx, ny, depth + 1, str + map[nx][ny]);
			}
		}
	}

}

// reference: https://zoonvivor.tistory.com/135
