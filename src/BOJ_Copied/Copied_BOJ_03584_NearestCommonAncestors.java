package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_03584_NearestCommonAncestors {

	static List<Integer>[] list;
	static int[] parent, depth;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			parent = new int[N + 1];
			depth = new int[N + 1];
			list = new ArrayList[N + 1]; // Index is parent. Inner values are children.
			boolean[] visited = new boolean[N + 1];
			Arrays.fill(visited, true);

			for (int i = 1; i < N + 1; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				visited[b] = false;
			}

			int rootIdx = 0;
			for (int i = 1; i < N + 1; i++) {
				if (visited[i]) {
					rootIdx = i;
					break;
				}
			}

			dfs(rootIdx, 1, 0);

			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			System.out.println(LCA(left, right));
		}

	}

	static void dfs(int cur, int height, int pa) {
		depth[cur] = height;
		parent[cur] = pa;
		for (int nxt : list[cur]) {
			if (nxt != pa) {
				dfs(nxt, height + 1, cur);
			}
		}
	}

	static int LCA(int a, int b) {
		// matching height
		int ah = depth[a];
		int bh = depth[b];
		while (ah > bh) {
			a = parent[a];
			ah--;
		}

		while (bh > ah) {
			b = parent[b];
			bh--;
		}

		while (a != b) {
			a = parent[a];
			b = parent[b];
		}

		return a;
	}
}

// reference: https://loosie.tistory.com/466
