package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657_NAndM_8 {
	static int N, M;
	static int[] input, result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);

		result = new int[M + 1];

		dfs(1);

		System.out.println(sb.toString());
	}

	private static void dfs(int depth) {

		if (depth == M + 1) {

			for (int i = 1; i <= M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append('\n');

		} else {

			for (int i = 0; i < N; i++) {

				result[depth] = input[i];

				if (result[depth] >= result[depth - 1])
					dfs(depth + 1);

			}
		}
	}

}
