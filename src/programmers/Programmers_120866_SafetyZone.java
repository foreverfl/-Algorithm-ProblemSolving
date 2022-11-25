package programmers;

public class Programmers_120866_SafetyZone {

	public static void main(String[] args) {

		System.out.println(solution(new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } }));
		System.out.println(solution(new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 0 } }));
		System.out.println(solution(new int[][] { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 } }));

	}

	private static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	private static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static int solution(int[][] board) {
		int n = board.length;
		int[][] check = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) {
					check[i][j] = 1;
					for (int k = 0; k < 8; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if (!isPossible(nx, ny, n))
							continue;

						check[nx][ny] = 2;
					}
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (check[i][j] == 0)
					answer++;
			}
		}

		return answer;
	}

	private static boolean isPossible(int x, int y, int n) {
		if (x < 0 || x >= n || y < 0 || y >= n) {
			return false;
		}

		return true;
	}

}
