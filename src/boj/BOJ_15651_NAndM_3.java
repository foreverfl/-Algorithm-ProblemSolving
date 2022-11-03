package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651_NAndM_3 {

	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		dfs(0);

		System.out.println(sb.toString());
	}

	private static void dfs(int depth) { // The 'at' means the starting point.

		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append('\n');
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i + 1;
			dfs(depth + 1);

		}
	}

}
