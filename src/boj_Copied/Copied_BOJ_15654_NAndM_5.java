package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_15654_NAndM_5 {

	static int N, M;
	static int[] input, result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N];
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);

		result = new int[M];

		dfs(0);

		System.out.println(sb.toString());
	}

	private static void dfs(int depth) {

		if (depth == M) {
			
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append('\n');
			
		} else {

			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					visited[i] = true;
					
					result[depth] = input[i];
					dfs(depth + 1);
					
					visited[i] = false;
				}
			}
		}
	}

}

// reference: https://hidelookit.tistory.com/59