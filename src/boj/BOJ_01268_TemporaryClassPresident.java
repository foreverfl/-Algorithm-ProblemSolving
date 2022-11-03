package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01268_TemporaryClassPresident {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N + 1][5 + 1];
		int[][] relation = new int[N + 1][N + 1]; // friend x friend

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 5; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// vertical search
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= N; j++) {
				int fix = input[j][i];
				for (int k = 1; k <= N; k++) {
					int searched = input[k][i];
					if (fix == searched) {
						relation[j][k] = relation[k][j] = 1;
					}
				}
			}
		}

		int[] cnt = new int[N + 1];
		for (int i = 1; i <= N; i++) { // initialization
			cnt[i] = -1;
		}

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				if (relation[i][j] == 1) {
					cnt[i]++;
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			if (cnt[i] > max) {
				max = cnt[i];
			}
		}

		for (int i = 1; i <= N; i++) {
			if (cnt[i] == max) {
				System.out.println(i);
				break;
			}
		}

	}

}
