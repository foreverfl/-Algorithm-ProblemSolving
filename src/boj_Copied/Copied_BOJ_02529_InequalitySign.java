package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_02529_InequalitySign {

	static int N;
	static char[] signs = new char[10];
	static boolean[] visited = new boolean[10];
	static List<String> ans = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			signs[i] = st.nextToken().charAt(0);

		backtracking("", 0);
		Collections.sort(ans);

		System.out.println(ans.get(ans.size() - 1));
		System.out.println(ans.get(0));

	}

	private static void backtracking(String num, int depth) {

		if (depth == N + 1) {
			ans.add(num);
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (visited[i])
				continue;
			if (depth == 0 || compare(Character.getNumericValue(num.charAt(depth - 1)), i, signs[depth - 1])) {
				visited[i] = true;
				backtracking(num + i, depth + 1);
				visited[i] = false;
			}
		}
	}

	private static boolean compare(int a, int b, char c) {
		if (c == '<') {
			if (a > b)
				return false;
		} else if (c == '>') {
			if (a < b)
				return false;
		}
		return true;
	}

}

// reference: https://pangtrue.tistory.com/283
