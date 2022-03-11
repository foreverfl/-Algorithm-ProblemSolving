package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652_NAndM_4 {

	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M + 1];

		dfs(1);

		System.out.println(sb.toString());
	}

	private static void dfs(int depth) {

		if (depth == M + 1) {
			for (int i = 1; i <= M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append('\n');
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i + 1;

			if (arr[depth] >= arr[depth - 1]) {
				dfs(depth + 1);
			}

		}
	}

}
