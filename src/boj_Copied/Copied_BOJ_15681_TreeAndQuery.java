package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Copied_BOJ_15681_TreeAndQuery {

	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int dp[];
	static int N, R, Q;
	static int query;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		dp = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			list[U].add(V);
			list[V].add(U);
		}

		dfs(R);

		while (Q-- > 0) {
			query = Integer.parseInt(br.readLine());

			sb.append(dp[query]).append('\n');
		}

		System.out.println(sb.toString());
	}

	public static int dfs(int now) {
		if (dp[now] != 0)
			return dp[now];

		visited[now] = true;
		int cnt = 1;

		for (int child : list[now]) {
			if (!visited[child])
				cnt += dfs(child);
		}

		dp[now] = cnt;

		return dp[now];
	}

}

// reference: https://bbangson.tistory.com/54