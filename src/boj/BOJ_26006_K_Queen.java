package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_26006_K_Queen {

	private static class Point {
		int x;
		int y;
		boolean isPossible = true;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", isPossible=" + isPossible + "]";
		}

	}

	private static int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	private static int dy[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	private static int N, K;
	private static Point king;
	private static List<Point> around = new ArrayList<>();
	private static List<Boolean> checkList = new ArrayList<>();
	private static Point[] queens;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		queens = new Point[K];

		st = new StringTokenizer(br.readLine());
		king = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		for (int i = 0; i < 8; i++) {
			if (isValid(king.x + dx[i], king.y + dy[i]))
				around.add(new Point(king.x + dx[i], king.y + dy[i]));
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			queens[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		checkPoint(king);
		for (int i = 0; i < around.size(); i++) {
			checkPoint(around.get(i));
			checkList.add(around.get(i).isPossible);
		}

//		System.out.println(king);
//		for (int i = 0; i < around.size(); i++)
//			System.out.println(around.get(i));
		

		if (!king.isPossible && checkList.contains(true)) {
			System.out.println("CHECK");
		} else if (!king.isPossible && !checkList.contains(true)) {
			System.out.println("CHECKMATE");
		} else if (king.isPossible && !checkList.contains(true)) {
			System.out.println("STALEMATE");
		} else {
			System.out.println("NONE");
		}

	}

	private static boolean isValid(int x, int y) {
		if (x >= 1 && x <= N && y >= 1 && y <= N)
			return true;

		return false;

	}

	private static void checkPoint(Point point) {
		for (int i = 0; i < queens.length; i++) {
			if (point.x == queens[i].x) {
				point.isPossible = false;
			}

			if (point.y == queens[i].y) {
				point.isPossible = false;
			}

			if ((point.x - point.y) == (queens[i].x - queens[i].y)) {
				point.isPossible = false;
			}

			if ((point.x + point.y) == (queens[i].x + queens[i].y)) {
				point.isPossible = false;
			}
		}
	}

}
