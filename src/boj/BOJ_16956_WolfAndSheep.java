package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16956_WolfAndSheep {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R + 2][C + 2];

		for (int i = 1; i <= R; i++) {
			String str = br.readLine();
			for (int j = 1; j <= C; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] == '.')
					map[i][j] = 'D';
			}
		}

		boolean flag = true;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] == 'S') {
					if (map[i - 1][j] == 'W' || map[i + 1][j] == 'W' || map[i][j - 1] == 'W' || map[i][j + 1] == 'W')
						flag = false;
				}
			}
		}

		if (flag) {
			sb.append(1).append('\n');

			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}
		} else {
			sb.append(0);
		}

		System.out.println(sb.toString());

	}

}
