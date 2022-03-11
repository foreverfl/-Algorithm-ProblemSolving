package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_15666_NAndM_12 {
	static int N, M;
	static Set<Integer> set = new HashSet<>();
	static Integer[] input;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		input = set.toArray(new Integer[set.size()]);

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

			for (int i = 0; i < input.length; i++) {

				result[depth] = input[i];

				if (result[depth] >= result[depth - 1])
					dfs(depth + 1);

			}
		}
	}

}
