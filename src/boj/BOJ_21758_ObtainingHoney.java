package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21758_ObtainingHoney {

	static int[] arr;
	static boolean[] visited;
	static boolean[] visited_bee;
	static int N;
	static int honey, bee_1, bee_2;
	static int max = Integer.MIN_VALUE, sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		visited_bee = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		findPointers();

		System.out.println(max);

	}

	private static void findPointers() {
		for (int i = 0; i < N; i++) { // The 'i' is a destination.
			honey = i;
			visited[honey] = true;

			if (!visited[0]) {
				bee_1 = 0;
				visited[bee_1] = true;
				visited_bee[bee_1] = true;
				for (int j = 0; j < N; j++) {
					if (!visited[j]) {
						bee_2 = j;
						visited[bee_2] = true;
						visited_bee[bee_2] = true;

						findMax(honey, bee_1, bee_2);

						visited[bee_2] = false;
						visited_bee[bee_2] = false;
					}
				}
				visited[bee_1] = false;
				visited_bee[bee_1] = false;

			}

			if (!visited[N - 1]) {
				bee_1 = N - 1;
				visited[bee_1] = true;
				visited_bee[bee_1] = true;
				for (int j = 0; j < N; j++) {
					if (!visited[j]) {
						bee_2 = j;
						visited[bee_2] = true;
						visited_bee[bee_2] = true;

						findMax(honey, bee_1, bee_2);

						visited[bee_2] = false;
						visited_bee[bee_2] = false;
					}
				}
				visited[bee_1] = false;
				visited_bee[bee_1] = false;
			}

			visited[honey] = false;

		}
	}

	private static void findMax(int honey, int bee_1, int bee_2) {
		if (bee_1 < honey) {
			for (int i = bee_1; i <= honey; i++) {
				if (visited_bee[i])
					continue;

				sum += arr[i];
			}
		} else {
			for (int i = bee_1; i >= honey; i--) {
				if (visited_bee[i])
					continue;

				sum += arr[i];
			}
		}

		if (bee_2 < honey) {
			for (int i = bee_2; i <= honey; i++) {
				if (visited_bee[i])
					continue;

				sum += arr[i];
			}
		} else {
			for (int i = bee_2; i >= honey; i--) {
				if (visited_bee[i])
					continue;

				sum += arr[i];
			}
		}

		max = Math.max(max, sum);
		sum = 0;
	}

}
