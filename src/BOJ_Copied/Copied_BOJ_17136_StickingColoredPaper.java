package BOJ_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_17136_StickingColoredPaper {

	static int[][] map;
	static int[] paper = { 0, 5, 5, 5, 5, 5 };
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[10][10];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		DFS(0, 0, 0);

		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}

		System.out.println(ans + "\n");

	}

	public static void DFS(int x, int y, int cnt) {
		if (x >= 9 && y > 9) {
			ans = Math.min(ans, cnt);
			return;
		}

		if (ans <= cnt) { // needless to search
			return;
		}

		if (y > 9) { // to the bottom
			DFS(x + 1, 0, cnt);
			return;
		}

		if (map[x][y] == 1) {
			for (int i = 5; i >= 1; i--) {
				if (paper[i] > 0 && canAttach(x, y, i)) {
					// attachment
					attach(x, y, i, 0);
					paper[i]--;

					DFS(x, y + 1, cnt + 1); // to the right

					// detachment
					attach(x, y, i, 1);
					paper[i]++;
				}
			}
		} else { // to the right
			DFS(x, y + 1, cnt);
		}
	}

	public static void attach(int x, int y, int size, int state) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = state;
			}
		}
	}

	public static boolean canAttach(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i < 0 || i >= 10 || j < 0 || j >= 10) {
					return false;
				}

				if (map[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}

}

// reference: https://steady-coding.tistory.com/43