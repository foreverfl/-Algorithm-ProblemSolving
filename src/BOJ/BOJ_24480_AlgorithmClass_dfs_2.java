package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_24480_AlgorithmClass_dfs_2 {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] order;
	static int N, M, R;
	static int idx = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		order = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			ArrayList<Integer> tmp = new ArrayList<>();
			graph[i] = tmp;
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 0; i <= N; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}

		dfs(R);

		for (int i = 1; i <= N; i++) {
			sb.append(order[i]).append('\n');
		}

		System.out.println(sb.toString());

	}

	public static void dfs(int num) {
		visited[num] = true;
		order[num] = idx;

		for (int now : graph[num]) {
			if (!visited[now]) {
				idx++;
				dfs(now);
			}
		}
	}
}
