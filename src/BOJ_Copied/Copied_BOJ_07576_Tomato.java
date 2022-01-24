package BOJ_Copied;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class tomato {
	int x; // width
	int y; // length

	tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Copied_BOJ_07576_Tomato {

	static int M; // width
	static int N; // length

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int[][] board;

	static Queue<tomato> queue;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		board = new int[N][M];

		queue = new LinkedList<tomato>();

		// input
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
				if (board[i][j] == 1) // if tomato is ripe.
					queue.add(new tomato(i, j));
			}
		}
		System.out.println(bfs());
	}

	public static int bfs() {
		while (!queue.isEmpty()) {
			tomato t = queue.poll();

			int x = t.x;
			int y = t.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (board[nx][ny] == 0) {
						queue.add(new tomato(nx, ny));
						board[nx][ny] = board[x][y] + 1; // To get the ripe day, increase 1.
					}
				}
			}
		}

		int result = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) // If there is tomato which is not ripe.
					return -1;

				result = Math.max(result, board[i][j]);

			}
		}

		if (result == 1)
			return 0;

		else
			return result - 1;
	}
}

// reference: https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-7576%EB%B2%88-%ED%86%A0%EB%A7%88%ED%86%A0-%EC%9E%90%EB%B0%94Java