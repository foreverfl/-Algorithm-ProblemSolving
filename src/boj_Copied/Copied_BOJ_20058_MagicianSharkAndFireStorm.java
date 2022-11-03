package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Copied_BOJ_20058_MagicianSharkAndFireStorm {

	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int N, Q, len;
	static int[] magics;
	static int sum, cnt_final;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		len = (int) Math.pow(2, N);

		map = new int[len][len];
		visited = new boolean[len][len];

		for (int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < len; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		magics = new int[Q];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			magics[i] = (Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < Q; i++) {
			map = divide(magics[i]);
			map = melt();

		}

//		for (int i = 0; i < len; i++) {
//			for (int j = 0; j < len; j++) {
//				System.out.printf("%2d ", map[i][j]);
//			}
//			System.out.println();
//		}

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				sum += map[i][j];
			}
		}

		count();

		System.out.println(sum);
		System.out.println(cnt_final);

	}

	public static int[][] divide(int L) {
		int[][] temp = new int[len][len];
		L = (int) Math.pow(2, L);

		for (int i = 0; i < len; i += L) {
			for (int j = 0; j < len; j += L) {
				rotate(i, j, L, temp);
			}
		}
		return temp;
	}

	public static void rotate(int r, int c, int L, int[][] temp) {
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++) {
				temp[r + j][c + L - i - 1] = map[r + i][c + j];
			}
		}
	}

	public static int[][] melt() { // considering melting 'at the same time'
		int[][] temp = new int[len][len];

		for (int i = 0; i < len; i++)
			temp[i] = Arrays.copyOf(map[i], len);

		for (int r = 0; r < len; r++) {
			for (int c = 0; c < len; c++) {

				int cnt = 0;
				if (map[r][c] == 0)
					continue;

				for (int i = 0; i < 4; i++) {
					int nr = r + dx[i];
					int nc = c + dy[i];

					if (nr < 0 || nc < 0 || nr >= len || nc >= len)
						continue;

					if (map[nr][nc] > 0) {
						cnt++;
					}
				}

				if (cnt < 3) {
					temp[r][c]--;
				}
			}
		}
		return temp;
	}

	public static void count() {
		Stack<int[]> stack = new Stack<>();
		cnt_final = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (map[i][j] > 0 && !visited[i][j]) {
					stack.push(new int[] { i, j });
					visited[i][j] = true;
					int count = 1;

					while (!stack.isEmpty()) {
						int[] temp = stack.pop();
						int r = temp[0];
						int c = temp[1];

						for (int k = 0; k < 4; k++) {
							int nr = r + dx[k];
							int nc = c + dy[k];

							if (nr < 0 || nc < 0 || nr >= len || nc >= len)
								continue;

							if (visited[nr][nc])
								continue;

							if (map[nr][nc] > 0) {
								count++;
								visited[nr][nc] = true;
								stack.push(new int[] { nr, nc });
							}
						}
					}
					cnt_final = Math.max(count, cnt_final);

				}
			}
		}
	}

}

// reference: https://skdltm117.tistory.com/32
