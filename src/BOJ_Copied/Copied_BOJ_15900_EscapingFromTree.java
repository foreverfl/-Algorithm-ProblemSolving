package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Copied_BOJ_15900_EscapingFromTree {

	static int N;
	static ArrayList<ArrayList<Integer>> list;
	static int ans;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		visited = new boolean[N + 1];

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list.get(x).add(y);
			list.get(y).add(x);
		}

		DFS(1, 0, visited);

		System.out.println((ans % 2 == 0) ? "No" : "Yes");

	}

	private static void DFS(int node, int cnt, boolean[] visited) {
		visited[node] = true;

		for (int next : list.get(node)) {
			if (!visited[next]) {
				DFS(next, cnt + 1, visited);
			}
		}

		// how to find a leaf node
		if (node != 1 && list.get(node).size() == 1) {
			ans += cnt;
		}
	}

}

// reference: https://steady-coding.tistory.com/192
