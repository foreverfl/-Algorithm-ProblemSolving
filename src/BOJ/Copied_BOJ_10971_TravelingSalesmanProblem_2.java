package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_10971_TravelingSalesmanProblem_2 {

	static int[][] map;
	static boolean[] visited;
	static int[] output;
	static int N;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N];
		output = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0] = true;
		dfs(0, 0, 1, 0);

		System.out.println(min);

	}

	private static void dfs(int start, int now, int depth, int cost) {
		if (now == start && cost > 0) {
			min = Math.min(min, cost);
			return;
		}

		for (int i = 0; i < N; i++) {

			if (map[now][i] != 0) {

				if (i == start && depth == N) { // When arrived at the first place. The depth is not the 'N-1' but
												// 'N' because of turning back.
					cost += map[now][i];
					dfs(start, i, depth + 1, cost);
				}

				else if (!visited[i]) {
					visited[i] = true;
					cost += map[now][i];

					dfs(start, i, depth + 1, cost);

					cost -= map[now][i];
					visited[i] = false;
				}
			}
		}
	}

}

// reference: https://lotuslee.tistory.com/92
