package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_05976_ASpiralWalk {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int idx = 1;
		int[][] arr = new int[N][N];

		int start = 0;
		int end = N;
		while (true) {
			for (int i = start; i < end; i++) {
				arr[start][i] = idx++;
			}
			for (int i = start + 1; i < end; i++) {
				arr[i][end - 1] = idx++;
			}
			for (int i = end - 2; i >= start; i--) {
				arr[end - 1][i] = idx++;
			}
			for (int i = end - 2; i > start; i--) {
				arr[i][start] = idx++;
			}
			start++;
			end--;
			if (start >= end)
				break;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");				
			}
			System.out.println();
		}

	}

}
