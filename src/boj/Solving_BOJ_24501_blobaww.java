package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solving_BOJ_24501_blobaww {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		int[][] dp1 = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 'E') {
					dp1[i][j] = 1;
				}

			}
		}
		int[][] dp2 = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 'S') {
					for (int a = 0; a <= i; a++) {
						for (int b = 0; b <= j; b++) {
							if (dp1[a][b] == 1) {
								dp2[i][j]++;
							}
						}
					}
				}

			}
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 'M') {
					for (int a = 0; a <= i; a++) {
						for (int b = 0; b <= j; b++) {
							if (dp2[a][b] == 1) {
								ans++;
							}
						}
					}
				}

			}
		}

		System.out.println(ans);
	}

}
