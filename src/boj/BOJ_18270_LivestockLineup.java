package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_18270_LivestockLineup {

	static StringBuilder sb = new StringBuilder();
	static String[] cows = { "Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy", "Sue" };
	static int[] idx = new int[8];
	static boolean[] visited = new boolean[8];
	static String[] ans = new String[8];
	static String[][] besides;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		besides = new String[N][2];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			String[] tmp = str.split(" ");
			besides[i][0] = tmp[0];
			besides[i][1] = tmp[5];
		}

		Arrays.sort(cows);

		backTracking(0);

	}

	public static void backTracking(int depth) {
		if (depth == 8) {
			for (int i = 0; i < 8; i++) {
				ans[i] = cows[idx[i]];
			}

			if (checkBesides()) {
				for (int i = 0; i < 8; i++) {
					sb.append(ans[i]).append('\n');
				}

				System.out.print(sb.toString().trim());
				System.exit(0);
			}
			return;
		}

		for (int i = 0; i < 8; i++) {
			if (!visited[i]) {
				visited[i] = true;
				idx[depth] = i;
				backTracking(depth + 1);
				visited[i] = false;
			}
		}
	}

	public static boolean checkBesides() {

		boolean[] check = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 8; j++) {
				if (j == 0) {
					if (ans[j].equals(besides[i][0])) {
						if (ans[j + 1].equals(besides[i][1]))
							check[i] = true;
					} else if (ans[j + 1].equals(besides[i][0])) {
						if (ans[j].equals(besides[i][1]))
							check[i] = true;
					}
				} else if (j == 7) {
					if (ans[j].equals(besides[i][0])) {
						if (ans[j - 1].equals(besides[i][1]))
							check[i] = true;
					} else if (ans[j - 1].equals(besides[i][0])) {
						if (ans[j].equals(besides[i][1]))
							check[i] = true;
					}
				} else {
					if (ans[j].equals(besides[i][0])) {
						if (ans[j - 1].equals(besides[i][1]))
							check[i] = true;
						else if (ans[j + 1].equals(besides[i][1]))
							check[i] = true;
					} else if (ans[j].equals(besides[i][1])) {
						if (ans[j - 1].equals(besides[i][0]))
							check[i] = true;
						else if (ans[j + 1].equals(besides[i][0]))
							check[i] = true;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			if (!check[i])
				return false;
		}

		return true;
	}

}
