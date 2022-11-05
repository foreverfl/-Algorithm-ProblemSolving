package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_21937_Operation {

	private static int N, M, X;
	private static int res;
	private static List<List<Integer>> operation;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		operation = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			operation.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			operation.get(B).add(A);
		}

		X = Integer.parseInt(br.readLine());

		dfs(X);

		System.out.println(res);

	}

	private static void dfs(int num) {

		for (int i = 0; i < operation.get(num).size(); i++) {
			if (!visited[operation.get(num).get(i)]) {
				visited[operation.get(num).get(i)] = true;
				res++;
				dfs(operation.get(num).get(i));
			}

		}

	}
}
