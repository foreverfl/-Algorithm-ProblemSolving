package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01783_IllKnight {

	static int[][] map;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		System.out.println(solve());
	}

	private static int solve() {
		if (N == 1) // Moving is impossible
			return 1;
		// The number of Maximum moving is 4.
		if (N == 2) // vertical limit
			return Math.min(4, (M + 1) / 2);
		if (M < 7) // horizontal limit: when the process 1~4 is finished, M �� M+6
			return Math.min(4, M);
		return M - 2;
	}
}

// reference: https://log-laboratory.tistory.com/80