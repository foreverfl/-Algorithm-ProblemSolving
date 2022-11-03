package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11586_MagicMirror {

	static char[][] mirror;
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		mirror = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				mirror[i][j] = str.charAt(j);
			}
		}

		K = Integer.parseInt(br.readLine());

		if (K == 1) { // as it is

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(mirror[i][j]);
				}
				System.out.println();
			}

		} else if (K == 2) { // left-right

			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					System.out.print(mirror[i][j]);
				}
				System.out.println();
			}

		} else if (K == 3) { // top-bottom

			for (int i = N - 1; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					System.out.print(mirror[i][j]);
				}
				System.out.println();
			}

		}

	}

}
