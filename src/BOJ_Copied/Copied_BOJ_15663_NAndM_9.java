package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Copied_BOJ_15663_NAndM_9 {
	static int N, M;
	static int[] input, result;
	static boolean[] visited;
	static LinkedHashSet<String> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N];
		visited = new boolean[N];
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
			if (visited[i])
				continue;

			visited[i] = true;
			result[depth] = input[i];
			dfs(depth + 1);
			visited[i] = false;

		}
	}

}

// reference: https://girawhale.tistory.com/72