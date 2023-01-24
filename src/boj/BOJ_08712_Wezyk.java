package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_08712_Wezyk {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][n];
		int now = 1;
		boolean isRight = true;

		for (int i = 0; i < n; i++) {

			if (isRight) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = now++;
				}

				isRight = false;
			} else {
				for (int j = n - 1; j >= 0; j--) {
					arr[i][j] = now++;
				}

				isRight = true;
			}

		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
