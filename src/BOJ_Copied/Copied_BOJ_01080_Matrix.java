package BOJ_Copied;

import java.util.*;
import java.io.*;

public class Copied_BOJ_01080_Matrix {
	static int n, m;
	static int a[][], b[][];

	public static boolean flip(int start_a, int start_b) {

		if (start_a + 3 > n || start_b + 3 > m)
			return false; // It returns false if the 'i' and 'j' is out of the scope.

		for (int i = start_a; i <= start_a + 2; i++) { // After operation, true is returned.
			for (int j = start_b; j <= start_b + 2; j++) {
				a[i][j] = 1 - (a[i][j]); // 1 → 0, 0 → 1
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		a = new int[n][m];
		b = new int[n][m];

		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				a[i][j] = row.charAt(j) - '0'; // String → Integer with ASCII Code 
			}
		}
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				b[i][j] = row.charAt(j) - '0';

			}
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (a[i][j] != b[i][j]) {
					if (flip(i, j)) {
						cnt++;
					} else {
						System.out.println("-1");
						return;
					}
				}

			}
		}

		System.out.println(cnt);
		br.close();

	}

}

// reference: https://fbtmdwhd33.tistory.com/12