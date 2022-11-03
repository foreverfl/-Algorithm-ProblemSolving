package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ_15665_NAndM_11 {

	static int N, M;
	static int[] input, result;
	static LinkedHashSet<String> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N];

		result = new int[M];
		ans = new LinkedHashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);

		dfs(0);

		ans.forEach(System.out::println);
	}

	private static void dfs(int depth) {

		StringBuilder sb = new StringBuilder();

		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			ans.add(sb.toString());
			return;
		}

		for (int i = 0; i < input.length; i++) {

			result[depth] = input[i];

			dfs(depth + 1);

		}
	}

}
