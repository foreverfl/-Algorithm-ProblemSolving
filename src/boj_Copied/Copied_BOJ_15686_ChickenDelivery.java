package boj_Copied;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Copied_BOJ_15686_ChickenDelivery {

	static int[][] map;
	static ArrayList<Point> home;
	static ArrayList<Point> chicken;
	static boolean[] visited;
	static int N, M;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		home = new ArrayList<>();
		chicken = new ArrayList<>();

		// inputting point
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1) {
					home.add(new Point(i, j));
				} else if (map[i][j] == 2) {
					chicken.add(new Point(i, j));
				}
			}
		}

		visited = new boolean[chicken.size()];

		dfs(0, 0);
		System.out.print(ans);

	}

	public static void dfs(int depth, int start) {
		if (depth == M) {
//			for (int i = 0; i < chicken.size(); i++) {
//				if (visited[i])
//					System.out.print(i + " ");
//			}
//			System.out.println();

			int res = 0;

			for (int i = 0; i < home.size(); i++) {
				int tmp = Integer.MAX_VALUE;

				for (int j = 0; j < chicken.size(); j++) {
					if (visited[j]) {
						int distance = Math.abs(home.get(i).x - chicken.get(j).x)
								+ Math.abs(home.get(i).y - chicken.get(j).y);

						tmp = Math.min(tmp, distance);
					}
				}
				res += tmp;
			}
			ans = Math.min(ans, res);
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			visited[i] = true;
			dfs(depth + 1, i + 1);
			visited[i] = false;
		}
	}

}

// reference: https://steady-coding.tistory.com/23
