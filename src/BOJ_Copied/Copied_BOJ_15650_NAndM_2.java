package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_15650_NAndM_2 {

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

		dfs(1, 0);

		System.out.println(sb.toString());
	}

	private static void dfs(int at, int depth) { // The 'at' means the starting point.

		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append('\n');
			return;
		}

		for (int i = at; i <= N; i++) {
			arr[depth] = i;
			dfs(i + 1, depth + 1);

		}
	}

}

// reference: https://st-lab.tistory.com/115
