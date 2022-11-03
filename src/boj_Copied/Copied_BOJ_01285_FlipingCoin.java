package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_01285_FlipingCoin {

	static int N;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int ans = Integer.MAX_VALUE;
		// checking all cases
		for (int bit = 0; bit < (1 << N); bit++) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				int back = 0;

				for (int j = 0; j < N; j++) {
					char now = map[j][i]; // The standard is column.

					if ((bit & (1 << j)) != 0) { // reversing row
						now = reverse(j, i);
					}

					if (now == 'T') {
						back++;
					}
				}
				sum += Math.min(back, N - back);
			}
			ans = Math.min(ans, sum);
		}
		System.out.print(ans);

	}

	public static char reverse(int x, int y) {
		if (map[x][y] == 'T') {
			return 'H';
		} else {
			return 'T';
		}
	}
}

// reference: https://gre-eny.tistory.com/279
