package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819_MaximizingDifference {

	static int N;
	static int[] arr;
	static int[] output;
	static boolean[] visited;
	static int sum, max = Integer.MIN_VALUE;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		output = new int[N];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		maximizeDiff(0);

		System.out.println(max);

	}

	private static void maximizeDiff(int depth) {
		if (depth == N) {
			for (int i = 0; i < N - 1; i++) {
				sum += Math.abs(output[i] - output[i + 1]);
			}
			max = Math.max(max, sum);
			sum = 0;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				maximizeDiff(depth + 1);
				visited[i] = false;
			}
		}
	}

}
