package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_02873_LUNAPARK {

	static int R, C;
	static int[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		StringBuffer sb = new StringBuffer();

		if (R % 2 != 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C - 1; j++) {
					if (i % 2 == 0)
						sb.append("R");
					else
						sb.append("L");
				}
				if (i < R - 1)
					sb.append("D");
			}
		}

		else if (R % 2 == 0 && C % 2 != 0) {
			for (int i = 0; i < C; i++) {
				for (int j = 0; j < R - 1; j++) {
					if (i % 2 == 0)
						sb.append("D");
					else
						sb.append("U");
				}
				if (i < C - 1)
					sb.append("R");
			}
		}

		else if (R % 2 == 0 && C % 2 == 0) {
			// finding the black cell whose value is minimum
			int mr = 0, mc = 0; // position
			int min = 1001;

			for (int i = 0; i < R; i++) {
				// starting points of black cell
				int j;
				if (i % 2 == 0)
					j = 1;
				else
					j = 0;
				for (; j < C; j += 2) {
					if (arr[i][j] < min) {
						min = arr[i][j];
						mr = i;
						mc = j;
					}
				}
			}

			StringBuffer sb_1 = new StringBuffer();
			StringBuffer sb_2 = new StringBuffer();
			int sr = 0, sc = 0;
			int er = R - 1, ec = C - 1;

			while (er - sr > 1) {
				if (sr / 2 < mr / 2) {
					for (int i = 0; i < C - 1; i++)
						sb_1.append("R");
					sb_1.append("D");

					for (int i = 0; i < C - 1; i++)
						sb_1.append("L");
					sb_1.append("D");
					sr += 2;
				}
				if (er / 2 > mr / 2) {
					for (int i = 0; i < C - 1; i++)
						sb_2.append("R");
					sb_2.append("D");

					for (int i = 0; i < C - 1; i++)
						sb_2.append("L");
					sb_2.append("D");
					er -= 2;
				}
			}

			while (ec - sc > 1) {
				if (sc / 2 < mc / 2) {
					sb_1.append("D");
					sb_1.append("R");
					sb_1.append("U");
					sb_1.append("R");
					sc += 2;
				}
				if (ec / 2 > mc / 2) {
					sb_2.append("D");
					sb_2.append("R");
					sb_2.append("U");
					sb_2.append("R");
					ec -= 2;
				}
			}
			if (mc == sc) {
				sb_1.append("R");
				sb_1.append("D");
			} else {
				sb_1.append("D");
				sb_1.append("R");
			}

			sb.append(sb_1);
			sb.append(sb_2.reverse());

		}
		System.out.println(sb.toString());

	}

}

// reference: https://lotuslee.tistory.com/76
