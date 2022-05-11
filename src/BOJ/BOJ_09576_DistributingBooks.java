package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_09576_DistributingBooks {

	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = M - 1; j >= 0; j--) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}

		System.out.println(sb.toString());

	}

}
