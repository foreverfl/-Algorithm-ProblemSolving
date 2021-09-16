package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jungol_1856 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String arr[] = str.split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		int[][] answer = new int[n][m];
		int num = 1;

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) { // The 'i' is an even number.
				for (int j = 0; j < m; j++) {
					answer[i][j] = num++;
				}
			} else { // The 'i' is an odd number.
				for (int j = m - 1; j >= 0; j--) {
					answer[i][j] = num++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(answer[i][j] + " "); // DO NOt use the 'println'.
			}
			System.out.println();

		}

	}

}
