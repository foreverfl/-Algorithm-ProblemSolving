package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01236_ProtectingCastle {

	static int[][] map;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		char[] check_vertical = new char[N];
		char[] check_horizontal = new char[M];

		// check
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'X') {
					check_horizontal[j] = 'X';
					check_vertical[i] = 'X';
				}
			}
		}

		int cnt_vertical = N;
		int cnt_horizontal = M;

		for (int i = 0; i < check_vertical.length; i++) {
			if (check_vertical[i] == 'X')
				cnt_vertical--;
		}

		for (int i = 0; i < check_horizontal.length; i++) {
			if (check_horizontal[i] == 'X')
				cnt_horizontal--;
		}

		int result = (cnt_vertical > cnt_horizontal) ? cnt_vertical : cnt_horizontal;

		System.out.println(result);

	}

}
