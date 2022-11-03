package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_13460_MakingBeadEscape_2 {

	static class Coordinate {
		int rx;
		int ry;
		int bx;
		int by;
		int cnt;

		Coordinate(int rx, int ry, int bx, int by, int cnt) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;

		}
	}

	static char[][] map;
	static boolean[][][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M, ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M][N][M];

		int bx = 0, by = 0, rx = 0, ry = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'R') {
					rx = i;
					ry = j;
				}
				if (map[i][j] == 'B') {
					bx = i;
					by = j;
				}
			}
		}

		bfs(rx, ry, bx, by, 0);

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

	private static void bfs(int rx, int ry, int bx, int by, int cnt) {
		Queue<Coordinate> queue = new LinkedList<>();
		queue.add(new Coordinate(rx, ry, bx, by, cnt));
		visited[rx][ry][bx][by] = true;

		while (!queue.isEmpty()) {
			Coordinate nxt = queue.poll();
			int cnt_tmp = nxt.cnt;

			if (cnt_tmp >= 10) {
				return;
			}

			for (int i = 0; i < 4; i++) {
				int rnx = nxt.rx;
				int rny = nxt.ry;
				int bnx = nxt.bx;
				int bny = nxt.by;

				// red bead
				while (map[rnx + dx[i]][rny + dy[i]] != '#') {
					rnx += dx[i];
					rny += dy[i];
					if (map[rnx][rny] == 'O')
						break;
				}

				// blue bead
				while (map[bnx + dx[i]][bny + dy[i]] != '#') {
					bnx += dx[i];
					bny += dy[i];
					if (map[bnx][bny] == 'O')
						break;
				}

				// blue bead -> goal
				if (map[bnx][bny] == 'O')
					continue;

				// red bead -> goal
				if (map[rnx][rny] == 'O') {
					ans = Math.min(ans, cnt_tmp + 1);
					return;
				}

				// When a blue bead touches red bead(meeting)
				if (rnx == bnx && rny == bny && map[rnx][rny] != 'O') {
					int red_move = Math.abs(rnx - nxt.rx) + Math.abs(rny - nxt.ry);
					int blue_move = Math.abs(bnx - nxt.bx) + Math.abs(bny - nxt.by);

					// When the blue comes first
					if (red_move > blue_move) {
						rnx -= dx[i];
						rny -= dy[i];
					} else { // When the red comes first
						bnx -= dx[i];
						bny -= dy[i];
					}
				}

				if (!visited[rnx][rny][bnx][bny]) {
					visited[rnx][rny][bnx][bny] = true;
					queue.add(new Coordinate(rnx, rny, bnx, bny, cnt_tmp + 1));
				}

			}
		}

	}

}

// reference: https://loosie.tistory.com/312