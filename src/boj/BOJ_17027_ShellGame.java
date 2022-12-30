package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17027_ShellGame {

	private static int N;
	private static int[] arr;
	private static int[][] games;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int ans = Integer.MIN_VALUE;
		N = Integer.parseInt(br.readLine());
		games = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			games[i][0] = Integer.parseInt(st.nextToken());
			games[i][1] = Integer.parseInt(st.nextToken());
			games[i][2] = Integer.parseInt(st.nextToken());
		}

		int point;
		arr = new int[4];
		arr[1] = 1;
		point = 0;
		for (int i = 0; i < N; i++) {
			swap(games[i][0], games[i][1]);
			if (arr[games[i][2]] == 1) {
				point++;
			}
		}
		ans = Math.max(ans, point);

		arr = new int[4];
		arr[2] = 1;
		point = 0;
		for (int i = 0; i < N; i++) {
			swap(games[i][0], games[i][1]);
			if (arr[games[i][2]] == 1) {
				point++;
			}
		}
		ans = Math.max(ans, point);

		arr = new int[4];
		arr[3] = 1;
		point = 0;
		for (int i = 0; i < N; i++) {

		}
		for (int i = 0; i < N; i++) {
			swap(games[i][0], games[i][1]);
			if (arr[games[i][2]] == 1) {
				point++;
			}
		}
		ans = Math.max(ans, point);

		System.out.println(ans);
	}

	private static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

}
