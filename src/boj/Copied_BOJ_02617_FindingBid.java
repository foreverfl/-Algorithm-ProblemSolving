package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_02617_FindingBid {
	private static boolean[] visit;
	private static int[][] dp = new int[100][2];
	@SuppressWarnings("unchecked")
	private static List<Integer>[] list = new ArrayList[100];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int half = (N + 1) / 2;
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int heavy = Integer.parseInt(st.nextToken());
			int light = Integer.parseInt(st.nextToken());

			list[heavy].add(light);
		}

		for (int i = 1; i <= N; i++) {
			visit = new boolean[100];
			dfs(i, i);
		}

		int result = 0;
		for (int i = 1; i <= N; i++)
			if (dp[i][0] >= half || dp[i][1] >= half)
				result++;

		System.out.println(result);
	}

	private static void dfs(int current, int start) {

		visit[current] = true;

		for (int next : list[current])
			if (!visit[next]) {
				dp[start][0]++; // 0 → lighter
				dp[next][1]++; // 1 → heavier
				dfs(next, start);
			}
	}
}

// reference: https://dev-gorany.tistory.com/164
