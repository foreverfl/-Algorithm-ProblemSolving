package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_16197_TwoCoins {

	static class coin {
		int y1;
		int x1;
		int y2;
		int x2;

		coin(int y1, int x1, int y2, int x2) {
			this.y1 = y1;
			this.x1 = x1;
			this.y2 = y2;
			this.x2 = x2;
		}
	}

	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int cnt = Integer.MAX_VALUE;
	static int N, M;
	static int x1, x2, y1, y2;
	static boolean isAble;
	static boolean getFirst;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'o') { // position of coins
					if (getFirst) {
						y2 = i;
						x2 = j;
					} else {
						y1 = i;
						x1 = j;
						getFirst = true;
					}
				}
			}
		}

		backTracking(new coin(y1, x1, y2, x2), 0);

		if (cnt == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(cnt);
		}
	}

	static public void backTracking(coin coins, int btncnt) {
		if (btncnt >= cnt || btncnt >= 10) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			int outsideCnt = 0;
			int nextX1 = coins.x1 + dx[i];
			int nextY1 = coins.y1 + dy[i];
			int nextX2 = coins.x2 + dx[i];
			int nextY2 = coins.y2 + dy[i];

			// checking whether the coin is outside or not
			if (nextX1 < 0 || nextX1 >= M || nextY1 < 0 || nextY1 >= N) {
				outsideCnt++;
			}
			if (nextX2 < 0 || nextX2 >= M || nextY2 < 0 || nextY2 >= N) {
				outsideCnt++;
			}

			if (outsideCnt == 2) {
				continue;
			}
			if (outsideCnt == 1) {
				cnt = Math.min(cnt, btncnt + 1);
				return;
			}

			// checking for the wall
			if (map[nextY1][nextX1] == '#') {
				nextX1 = coins.x1;
				nextY1 = coins.y1;
			}
			if (map[nextY2][nextX2] == '#') {
				nextX2 = coins.x2;
				nextY2 = coins.y2;
			}

			backTracking(new coin(nextY1, nextX1, nextY2, nextX2), btncnt + 1);
		}
	}
}

// reference: https://maivve.tistory.com/247