package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solving_BOJ_26603_FraudDice {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			int[] tmp = new int[4];
			boolean[] visited = new boolean[4];
			for (int j = 0; j < 4; j++) {
				tmp[j] = arr[i][j];
			}
			backTracking(i, arr, tmp, visited, 0, 4, 3);
		}

		System.out.println("Hmm...");
	}

	private static void backTracking(int now, int[][] total, int[] arr, boolean[] visited, int depth, int n, int r) {
		if (r == 0) {
			Set<Integer> set_3 = new HashSet<>();
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					set_3.add(arr[i]);
				}
			}

			for (int i = 0; i < total.length; i++) {
				if (i == now) {
					continue;
				}

				Set<Integer> set_4 = new HashSet<>();
				for (int j = 0; j < 4; j++) {
					set_4.add(total[i][j]);
				}

				if (set_4.containsAll(set_3)) {
					System.out.println("You're gonna die!");
					System.exit(0);
				}
			}

			return;
		}

		for (int i = depth; i < n; i++) {
			visited[i] = true;
			backTracking(now, total, arr, visited, i + 1, n, r - 1);
			visited[i] = false;
		}
	}

}
