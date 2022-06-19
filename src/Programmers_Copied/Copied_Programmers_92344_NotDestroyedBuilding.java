package Programmers_Copied;

public class Copied_Programmers_92344_NotDestroyedBuilding {

	public static void main(String[] args) {
		int[][] board_1 = { { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 } };
		int[][] skill_1 = { { 1, 0, 0, 3, 4, 4 }, { 1, 2, 0, 2, 3, 2 }, { 2, 1, 0, 3, 1, 2 }, { 1, 0, 1, 3, 3, 1 } };
		int res_1 = solution(board_1, skill_1);
		System.out.println(res_1);

		int[][] board_2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] skill_2 = { { 1, 1, 1, 2, 2, 4 }, { 1, 0, 0, 1, 1, 2 }, { 2, 2, 0, 2, 0, 100 } };
		int res_2 = solution(board_2, skill_2);
		System.out.println(res_2);
	}

	static int[][] sum;
	static int N, M;

	public static int solution(int[][] board, int[][] skill) {
		N = board.length;
		M = board[0].length;

		sum = new int[N + 1][M + 1];
		for (int[] s : skill) {
			int r1 = s[1], c1 = s[2];
			int r2 = s[3], c2 = s[4];
			int degree = s[5] * (s[0] == 1 ? -1 : 1);

			sum[r1][c1] += degree;
			sum[r1][c2 + 1] += (degree * -1);
			sum[r2 + 1][c1] += (degree * -1);
			sum[r2 + 1][c2 + 1] += degree;
		}
		operate();

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] + sum[i][j] > 0)
					ans++;
			}
		}
		return ans;
	}

	public static void operate() {
		// up-down
		for (int y = 1; y < N; y++) {
			for (int x = 0; x < M; x++) {
				sum[y][x] += sum[y - 1][x];
			}
		}
		// left-right
		for (int x = 1; x < M; x++) {
			for (int y = 0; y < N; y++) {
				sum[y][x] += sum[y][x - 1];
			}
		}
	}

}

// reference: https://jangcenter.tistory.com/121
