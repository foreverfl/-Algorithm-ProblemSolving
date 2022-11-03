package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_Tetromino {

	static int[][] map;
	static int[][] I = { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 } };
	static int[][] I_180 = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } };
	
	static int[][] O = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
	
	static int[][] S = { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } };
	static int[][] S_180 = { { 0, 0 }, { 0, 1 }, { -1, 1 }, { -1, 2 } };
	
	static int[][] Z = { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } };
	static int[][] Z_180 = { { 0, 0 }, { 1, 0 }, { 1, -1 }, { 2, -1 } };
	
	static int[][] L = { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, 1 } };
	static int[][] L_90 = { { 0, 0 }, { -1, 0 }, { -1, 1 }, { -1, 2 } };
	static int[][] L_180 = { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 } };
	static int[][] L_270 = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 2 } };
	
	static int[][] J = { { 0, 0 }, { 0, 1 }, { -1, 1 }, { -2, 1 } };
	static int[][] J_90 = { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 } };
	static int[][] J_180 = { { 0, 0 }, { -1, 0 }, { -2, 0 }, { -2, 1 } };
	static int[][] J_270 = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } };
	
	static int[][] T = { { 0, 0 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static int[][] T_90 = { { 0, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 } };
	static int[][] T_180 = { { 0, 0 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
	static int[][] T_270 = { { 0, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 } };
	static int N, M;
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}		

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ans = Math.max(ans, find(i, j, I, 0));
				ans = Math.max(ans, find(i, j, I_180, 0));
				ans = Math.max(ans, find(i, j, O, 0));
				ans = Math.max(ans, find(i, j, Z, 0));
				ans = Math.max(ans, find(i, j, Z_180, 0));
				ans = Math.max(ans, find(i, j, S, 0));
				ans = Math.max(ans, find(i, j, S_180, 0));
				ans = Math.max(ans, find(i, j, J, 0));
				ans = Math.max(ans, find(i, j, J_90, 0));
				ans = Math.max(ans, find(i, j, J_180, 0));
				ans = Math.max(ans, find(i, j, J_270, 0));
				ans = Math.max(ans, find(i, j, L, 0));
				ans = Math.max(ans, find(i, j, L_90, 0));
				ans = Math.max(ans, find(i, j, L_180, 0));
				ans = Math.max(ans, find(i, j, L_270, 0));
				ans = Math.max(ans, find(i, j, T, 0));
				ans = Math.max(ans, find(i, j, T_90, 0));
				ans = Math.max(ans, find(i, j, T_180, 0));
				ans = Math.max(ans, find(i, j, T_270, 0));
			}
		}

		System.out.print(ans);

	}

	public static int find(int x, int y, int[][] block, int sum) {
		int res = sum;
		for (int i = 0; i < block.length; i++) {
			int nx = x + block[i][0];
			int ny = y + block[i][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				return Integer.MIN_VALUE;

			res += map[nx][ny];
		}

		return res;
	}

}
