package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_01325_EffectiveHacking {

	static List<Integer>[] list;
	static int[] visited = new int[10001];
	static int[] ans = new int[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		visited = new int[N + 1];
		ans = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
		}

		for (int i = 1; i <= N; i++) {
			visited = new int[N + 1];
			visited[i] = 1;
			dfs(i);
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, ans[i]);
		}

		for (int i = 1; i <= N; i++) {
			if (max == ans[i])
				sb.append(i + " ");
		}
		System.out.println(sb.toString());

	}

	private static void dfs(int node) {
		for (int next : list[node]) {
			if (visited[next] == 0) {
				ans[next]++;
				visited[next] = 1;
				dfs(next);
			}
		}
	}

}

// reference: https://smartpro.tistory.com/23
