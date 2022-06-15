package Programmers;

public class Copied_Programmers_92345_DisappearingFoothold {

	public static void main(String[] args) {
//		int[][] board_1 = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
//		int[] aloc_1 = { 1, 0 };
//		int[] bloc_1 = { 1, 2 };
//		int res_1 = solution(board_1, aloc_1, bloc_1);
//		System.out.println(res_1);
//
//		int[][] board_2 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
//		int[] aloc_2 = { 1, 0 };
//		int[] bloc_2 = { 1, 2 };
//		int res_2 = solution(board_2, aloc_2, bloc_2);
//		System.out.println(res_2);

		int[][] board_3 = { { 1, 1, 1, 1, 1 } };
		int[] aloc_3 = { 0, 0 };
		int[] bloc_3 = { 0, 4 };
		int res_3 = solution(board_3, aloc_3, bloc_3);
		System.out.println(res_3);

	}

	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int N, M;
	static int MAX = 987654321;

	static class turn {
		boolean isWin;
		int cnt;

		turn(boolean isWin, int cnt) {
			this.cnt = cnt;
			this.isWin = isWin;
		}
	}

	public static int solution(int[][] board, int[] aloc, int[] bloc) {
		N = board.length;
		M = board[0].length;

		turn res = dfs(board, aloc, bloc, true, 0); // starting from A turn.

		return res.cnt;
	}

	private static turn dfs(int[][] board, int[] aloc, int[] bloc, boolean isATurn, int cnt) {
		int ay = aloc[0];
		int ax = aloc[1];
		int by = bloc[0];
		int bx = bloc[1];

		if ((board[ay][ax] == 0 && isATurn) || (board[by][bx] == 0 && !isATurn))
			return new turn(false, cnt);

		int win = MAX;
		int lose = 0;
		int y, x;

		if (isATurn) {
			y = ay;
			x = ax;
		} else {
			y = by;
			x = bx;
		}

		board[y][x] = 0; // processing visit

		turn res = null;
		boolean canGo = false;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || nx < 0 || ny >= N || nx >= M)
				continue;

			if (board[ny][nx] == 0)
				continue;

			canGo = true;
			if (isATurn) {
				res = dfs(board, new int[] { ny, nx }, bloc, !isATurn, cnt + 1);
			} else {
				res = dfs(board, aloc, new int[] { ny, nx }, !isATurn, cnt + 1);
			}

			// The second is a winner. -> maximum movement
			if (res.isWin) {
				lose = Math.max(lose, res.cnt);
			}
			// The first is a winner. -> minimum movement
			else {
				win = Math.min(win, res.cnt);
			}
		}

		board[y][x] = 1;
		// can't go anywhere.
		if (!canGo) {
			return new turn(false, cnt);
		}
		// The first is a winner.
		else if (win != MAX) {
			return new turn(true, win);
		}
		// The second is a winner.
		else {
			return new turn(false, lose);
		}
	}

}

// reference: https://jangcenter.tistory.com/124
