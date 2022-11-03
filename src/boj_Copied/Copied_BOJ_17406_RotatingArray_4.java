package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_17406_RotatingArray_4 {

	static int[][] original;
	static int N, M, K;
	static int[][] rotation;
	static boolean[] visited;
	static int[] result;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		original = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				original[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rotation = new int[K][3];
		result = new int[K];
		visited = new boolean[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			rotation[i][0] = Integer.parseInt(st.nextToken());
			rotation[i][1] = Integer.parseInt(st.nextToken());
			rotation[i][2] = Integer.parseInt(st.nextToken());
		}

		backTracking(0, K);

		System.out.println(ans);

	}

	private static void backTracking(int depth, int k) {
		if (depth == k) {
			int[][] copied = new int[N + 1][M + 1];
			for (int i = 0; i < original.length; i++) {
				System.arraycopy(original[i], 0, copied[i], 0, original[0].length);
			}
			findMatrix(copied);

			return;
		}

		for (int i = 0; i < k; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[depth] = i;
				backTracking(depth + 1, k);
				visited[i] = false;
			}
		}

	}

	private static void findMatrix(int[][] copied) {
		for (int i = 0; i < result.length; i++) {
			rotate(rotation[result[i]][0], rotation[result[i]][1], rotation[result[i]][2], copied);
		}
		findMin(copied);
	}

	private static void findMin(int[][] map) {
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= M; j++) {
				sum += map[i][j];
			}
			ans = Math.min(ans, sum);
		}
	}

	private static void rotate(int r, int c, int s, int[][] map) {

		int v_start = r - s;
		int v_end = r + s;
		int h_start = c - s;
		int h_end = c + s;

		while (true) {
			List<Integer> list = new ArrayList<>();
			int i = v_start;
			int j = h_start;
			// input
			// ��
			for (; j < h_end; j++) {
				list.add(map[i][j]);
			}

			// ��
			for (; i < v_end; i++) {
				list.add(map[i][j]);
			}

			// ��
			for (; j > h_start; j--) {
				list.add(map[i][j]);
			}

			// ��
			for (; i > v_start; i--) {
				list.add(map[i][j]);
			}

			// exit
			if (list.isEmpty())
				break;

			// rotation
			int tmp = list.remove(list.size() - 1);
			list.add(0, tmp);

			// output
			// ��
			for (; j < h_end; j++) {
				map[i][j] = list.remove(0);
			}

			// ��
			for (; i < v_end; i++) {
				map[i][j] = list.remove(0);
			}

			// ��
			for (; j > h_start; j--) {
				map[i][j] = list.remove(0);
			}

			// ��
			for (; i > v_start; i--) {
				map[i][j] = list.remove(0);
			}

			v_start++;
			v_end--;
			h_start++;
			h_end--;

		}
	}

}

// reference: https://moonsbeen.tistory.com/4
