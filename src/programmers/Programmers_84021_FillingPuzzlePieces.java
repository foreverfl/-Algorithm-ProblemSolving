package programmers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Programmers_84021_FillingPuzzlePieces {

	public static void main(String[] args) {
		System.out.println(solution(
				new int[][] { { 1, 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 0, 1 }, { 1, 1, 0, 1, 1, 1 },
						{ 1, 0, 0, 0, 1, 0 }, { 0, 1, 1, 1, 0, 0 } },
				new int[][] { { 1, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 1, 1 }, { 0, 0, 1, 0, 0, 0 },
						{ 1, 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0, 0 } }));

		System.out.println(solution(new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 1 } },
				new int[][] { { 1, 1, 1 }, { 1, 0, 0 }, { 0, 0, 0 } }));
	}

	private static class Piece {
		List<Point> origin = new ArrayList<>();
		List<Point> reversedX = new ArrayList<>();
		List<Point> reversedY = new ArrayList<>();
		List<Point> reversedXY = new ArrayList<>();

		public Piece() {

		}

		@Override
		public String toString() {
			return "Piece [origin=" + origin.toString() + ", reversedX=" + reversedX.toString() + ", reversedY="
					+ reversedY.toString() + ", reversedXY=" + reversedXY.toString() + "]";
		}

		private void reverseX() {
			for (int i = 0; i < origin.size(); i++) {
				int nx = origin.get(i).x;
				int ny = -origin.get(i).y;

				if (!isValid(nx, ny)) {
					reversedX.clear();
					return;
				}

				reversedX.add(new Point(nx, ny));

			}
		}

		private void reverseY() {
			for (int i = 0; i < origin.size(); i++) {
				int nx = -origin.get(i).x;
				int ny = origin.get(i).y;

				if (!isValid(nx, ny)) {
					reversedY.clear();
					return;
				}

				reversedY.add(new Point(nx, ny));

			}
		}

		private void reverseXY() {
			for (int i = 0; i < origin.size(); i++) {
				int nx = -origin.get(i).x;
				int ny = -origin.get(i).y;

				if (!isValid(nx, ny)) {
					reversedXY.clear();
					return;
				}

				reversedXY.add(new Point(nx, ny));

			}
		}

	}

	private static int[][] board_use;
	private static int[][] table_use;
	private static boolean[][] visited_board;
	private static boolean[][] visited_table;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	private static int x, y, ans;
	private static List<Piece> emptyParts = new ArrayList<>();
	private static List<Piece> pieces = new ArrayList<>();

	public static int solution(int[][] game_board, int[][] table) {
		x = game_board.length;
		y = game_board[0].length;

		board_use = new int[x][y];
		table_use = new int[x][y];

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				board_use[i][j] = game_board[i][j];
				table_use[i][j] = table[i][j];
			}
		}
		visited_board = new boolean[x][y];
		visited_table = new boolean[x][y];

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (!visited_board[i][j] && board_use[i][j] == 0) {

					Piece piece = new Piece();
					piece = findEmptyParts(i, j, piece);
					emptyParts.add(piece);
				}

				if (!visited_table[i][j] && board_use[i][j] == 1) {

					Piece piece = new Piece();
					piece = findPieces(i, j, piece);
					piece.reverseX();
					piece.reverseY();
					piece.reverseXY();
					pieces.add(piece);
				}

			}

		}

		fillPieces(emptyParts, pieces);

		int answer = ans;
		return answer;
	}

	// bfs -> depth를 알 수가 없다.
	private static Piece findEmptyParts(int x, int y, Piece piece) {

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));
		visited_board[x][y] = true;
		piece.origin.add(new Point(x, y));

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (!isValid(nx, ny))
					continue;

				if (visited_board[nx][ny])
					continue;

				if (board_use[nx][ny] == 0) {
					visited_board[nx][ny] = true;
					piece.origin.add(new Point(nx, ny));
					queue.add(new Point(nx, ny));
				}

			}
		}

		return piece;

	}

	private static Piece findPieces(int x, int y, Piece piece) {

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));
		visited_table[x][y] = true;
		piece.origin.add(new Point(x, y));

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (!isValid(nx, ny))
					continue;

				if (visited_table[nx][ny])
					continue;

				if (table_use[nx][ny] == 1) {
					visited_table[nx][ny] = true;
					piece.origin.add(new Point(nx, ny));
					queue.add(new Point(nx, ny));
				}

			}
		}

		return piece;
	}

	private static void fillPieces(List<Piece> emptyParts, List<Piece> pieces) {
		loopA: for (int i = 0; i < emptyParts.size(); i++) {
			for (int j = 0; j < pieces.size(); j++) {
				int emptyPartCnt = emptyParts.get(i).origin.size();
				int pieceCnt = pieces.get(j).origin.size();

				if (emptyPartCnt == pieceCnt) {
					for (int k = 0; k < pieceCnt; k++) {
						List<Point> emptyPart = emptyParts.get(i).origin;
						List<Point> pieceOrigin = pieces.get(i).origin;
						List<Point> pieceReversedX = pieces.get(i).reversedX;
						List<Point> pieceReversedY = pieces.get(i).reversedY;
						List<Point> pieceReversedXY = pieces.get(i).reversedXY;

						if (isSame(emptyPart, pieceOrigin)) {
							pieces.remove(i);
							ans += pieceCnt;
							continue loopA;
						} else if (isSame(emptyPart, pieceReversedX)) {
							pieces.remove(i);
							ans += pieceCnt;
							continue loopA;
						} else if (isSame(emptyPart, pieceReversedY)) {
							pieces.remove(i);
							ans += pieceCnt;
							continue loopA;
						} else if (isSame(emptyPart, pieceReversedXY)) {
							pieces.remove(i);
							ans += pieceCnt;
							continue loopA;
						}
					}
				} else {
					continue;
				}
			}
		}
	}

	private static boolean isSame(List<Point> A, List<Point> B) {
		if (A.size() == 0 || B.size() == 0)
			return false;

		for (int i = 0; i < A.size(); i++) {
			if ((A.get(i).x != B.get(i).x) || (A.get(i).y != B.get(i).y))
				return false;
		}

		return true;
	}

	private static boolean isValid(int a, int b) {
		if (a >= 0 && a < x && b >= 0 && b < y)
			return true;

		return false;
	}

}
