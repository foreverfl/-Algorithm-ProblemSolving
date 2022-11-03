package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_12100_2048_Easy {

	static int[][] map;
	static int N;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		game(0);

		System.out.println(ans);

	}

	private static void game(int depth) {
		if (depth == 5) {
			findMax();
			return;
		}
		int copy[][] = new int[N][N];
		
		for (int i = 0; i < N; i++) // deep copy
			copy[i] = map[i].clone();

		// Because of considering all cases, there is no need to use the visit array.
		for (int i = 0; i < 4; i++) {
			move(i);
			game(depth + 1);
			for (int a = 0; a < N; a++) // restoration by deep copy
				map[a] = copy[a].clone();
		}
	}

	private static void move(int dir) {
		switch (dir) {
		case 0: // to the top
			for (int i = 0; i < N; i++) {
				int index = 0;
				int block = 0;
				for (int j = 0; j < N; j++) {
					if (map[j][i] != 0) { // vertical search (��)
						if (block == map[j][i]) {
							map[index - 1][i] = block * 2;
							block = 0;
							map[j][i] = 0;
						} else {
							block = map[j][i];
							map[j][i] = 0;
							map[index][i] = block;
							index++;
						}
					}
				}
			}
			break;

		case 1: // to the bottom
			for (int i = 0; i < N; i++) {
				int index = N - 1;
				int block = 0;
				for (int j = N - 1; j >= 0; j--) {
					if (map[j][i] != 0) { // vertical search (��)
						if (block == map[j][i]) {
							map[index + 1][i] = block * 2;
							block = 0;
							map[j][i] = 0;
						} else {
							block = map[j][i];
							map[j][i] = 0;
							map[index][i] = block;
							index--;
						}
					}
				}
			}
			break;

		case 2: // to the left
			for (int i = 0; i < N; i++) {
				int index = 0;
				int block = 0;
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0) { // horizontal search (��)
						if (block == map[i][j]) {
							map[i][index - 1] = block * 2;
							block = 0;
							map[i][j] = 0;
						} else {
							block = map[i][j];
							map[i][j] = 0;
							map[i][index] = block;
							index++;
						}
					}
				}
			}
			break;

		case 3: // to the right
			for (int i = 0; i < N; i++) {
				int index = N - 1;
				int block = 0;
				for (int j = N - 1; j >= 0; j--) {
					if (map[i][j] != 0) { // horizontal search (��)
						if (block == map[i][j]) {
							map[i][index + 1] = block * 2;
							block = 0;
							map[i][j] = 0;
						} else {
							block = map[i][j];
							map[i][j] = 0;
							map[i][index] = block;
							index--;
						}
					}
				}
			}
			break;
		}
	}

	private static void findMax() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				ans = Math.max(ans, map[i][j]);
	}
}

// reference: https://jellyinghead.tistory.com/53