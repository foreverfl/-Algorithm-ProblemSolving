package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_02644_CalculatingDegreeOfKinship {

	static int[][] family;
	static boolean[] check;
	static int answer, n, m;
	static boolean find;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		family = new int[n][n];
		check = new boolean[n];

		st = new StringTokenizer(br.readLine());
		int man1 = Integer.parseInt(st.nextToken()) - 1;
		int man2 = Integer.parseInt(st.nextToken()) - 1;

		m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken()) - 1;
			int second = Integer.parseInt(st.nextToken()) - 1;

			family[first][second] = 1;
			family[second][first] = 1;
		}

		dfs(man1, man2, 0);

		if (!find)
			answer = -1;
		System.out.println(answer);
	}

	public static void dfs(int man1, int man2, int cnt) {
		check[man1] = true;

		if (man1 == man2) {
			find = true;
			answer = cnt;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!check[i] && family[man1][i] == 1) {
				check[i] = true;
				dfs(i, man2, cnt + 1);
				check[i] = false;
			}
		}

	}
}

// https:// drcode-devblog.tistory.com/301