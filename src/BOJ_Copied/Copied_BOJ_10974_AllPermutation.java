package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_10974_AllPermutation {

	static int N;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];

		backtracking(0);

		System.out.println(sb.toString());
	}

	private static void backtracking(int depth) {
		if (depth == N) {
			for (int i = 0; i < N; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append('\n');
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;
				backtracking(depth + 1);
				visited[i] = false;
			}
		}
	}

}

// reference: https://bcp0109.tistory.com/13
