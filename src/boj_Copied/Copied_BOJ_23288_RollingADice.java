package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_23288_RollingADice {

	private static class Dice {
		int up, down, left, right, front, back;

		public Dice() {
			up = 1;
			down = 6;
			left = 4;
			right = 3;
			front = 5;
			back = 2;
		}

		private void rollDice(int dir) {
			if (dir == 0)
				toNorth();
			else if (dir == 1)
				toEast();
			else if (dir == 2)
				toSouth();
			else
				toWest();
		}

		private void toEast() {
			int save = up;
			up = left;
			left = down;
			down = right;
			right = save;
		}

		private void toWest() {
			int save = up;
			up = right;
			right = down;
			down = left;
			left = save;
		}

		private void toNorth() {
			int save = up;
			up = front;
			front = down;
			down = back;
			back = save;
		}

		private void toSouth() {
			int save = up;
			up = back;
			back = down;
			down = front;
			front = save;
		}

	}

	private static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int n, m, k;
	private static int[][] board;
	// up, right, down, left
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		init();

		Dice dice = new Dice();
		int x = 0, y = 0;
		int dir = 1; // start direction = right
		int answer = 0;

		while (k-- > 0) {
			if (!valid(x + dx[dir], y + dy[dir]))
				dir = reverseDir(dir);

			x = x + dx[dir];
			y = y + dy[dir];

			dice.rollDice(dir);

			answer += getScore(x, y);
			dir = getNextDir(dice.down, board[x][y], dir);
		}

		System.out.println(answer);

	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static boolean valid(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		else
			return true;
	}

	private static int reverseDir(int dir) {
		return (dir + 2) % 4;
	}

	private static int getNextDir(int diceBottom, int boardNum, int dir) {
		if (diceBottom > boardNum) { // clockwise
			return (dir + 1) % 4;
		} else if (diceBottom < boardNum) { // counter-clockwise
			return (dir + 3) % 4;
		} else
			return dir;
	}

	private static int getScore(int x, int y) {
		boolean[][] visited = new boolean[n][m];
		visited[x][y] = true;
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));

		int num = board[x][y];
		int count = 1;
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nextX = now.x + dx[dir];
				int nextY = now.y + dy[dir];
				if (valid(nextX, nextY) && !visited[nextX][nextY] && board[nextX][nextY] == num) {
					visited[nextX][nextY] = true;
					count++;
					queue.add(new Node(nextX, nextY));
				}
			}
		}

		return num * count;
	}

}

// reference: https://velog.io/@mincho920/%EB%B0%B1%EC%A4%8023288Java-%EC%A3%BC%EC%82%AC%EC%9C%84-%EA%B5%B4%EB%A6%AC%EA%B8%B0-2%EC%B4%88%EA%B0%84%EB%8B%A8-%EC%84%A4%EB%AA%85
