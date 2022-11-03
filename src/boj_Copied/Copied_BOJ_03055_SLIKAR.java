package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_03055_SLIKAR {

	static class Node {
		int x;
		int y;
		int move;

		public Node(int x, int y, int move) {
			this.x = x;
			this.y = y;
			this.move = move;
		}
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static char[][] map;
	static boolean[][] check, wcheck;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<Node> q = new LinkedList<>();
	static Queue<Node> wq = new LinkedList<>();
	static int r, c, res = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		check = new boolean[r][c];
		wcheck = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] != '.') {
					if (map[i][j] == 'S') {
						// adding the first value
						q.add(new Node(i, j, 0));
					} else if (map[i][j] == '*') {
						wq.add(new Node(i, j));
					}
				}
			}
		}

		bfs();

		System.out.println(res == -1 ? "KAKTUS" : res);
	}

	private static void bfs() {

		while (true) {
			waterMove();

			int size = q.size();

			if (size == 0)
				break;

			for (int t = 0; t < size; t++) {
				Node next = q.poll();
				int move = next.move;

				for (int i = 0; i < 4; i++) {
					int nx = next.x + dx[i];
					int ny = next.y + dy[i];

					if (nx < 0 || ny < 0 || nx >= r || ny >= c)
						continue;

					if (check[nx][ny])
						continue;

					if (map[nx][ny] == 'D') {
						res = move + 1;
						return;
					}

					if (map[nx][ny] == '.' && !wcheck[nx][ny]) {
						check[nx][ny] = true;
						q.add(new Node(nx, ny, move + 1));
					}

				}
			}
		}

	}

	private static void waterMove() {
		int size = wq.size();
		for (int i = 0; i < size; i++) {
			Node next = wq.poll();

			for (int j = 0; j < 4; j++) {
				int nx = next.x + dx[j];
				int ny = next.y + dy[j];

				if (nx < 0 || ny < 0 || nx >= r || ny >= c)
					continue;

				if (wcheck[nx][ny])
					continue;

				if (map[nx][ny] == '.') {
					wcheck[nx][ny] = true;
					wq.add(new Node(nx, ny));
				}

			}
		}

	}

}

// reference: https://loosie.tistory.com/180
