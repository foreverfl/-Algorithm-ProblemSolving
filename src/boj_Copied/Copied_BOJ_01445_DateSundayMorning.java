package boj_Copied;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Copied_BOJ_01445_DateSundayMorning {

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int g;
		int b;

		public Node(int x, int y, int g, int b) {
			this.x = x;
			this.y = y;
			this.g = g;
			this.b = b;
		}

		@Override
		public int compareTo(Node o) {
			if (this.g == o.g) {
				return this.b - o.b;
			}

			return this.g - o.g;
		}

	}

	static char[][] map;
	static boolean[][] visited;
	static int N, M;
	static Node start;
	static List<Point> list;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];

		list = new ArrayList<Point>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == 'S')
					start = new Node(i, j, 0, 0);

				if (map[i][j] == 'g')
					list.add(new Point(i, j));
			}
		}

		make_b();

		int result_g = 0;
		int result_b = 0;

		PriorityQueue<Node> pq = new PriorityQueue<Node>();

		pq.add(start);
		visited[start.x][start.y] = true;

		loop: while (!pq.isEmpty()) {
			Node now = pq.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				int g = now.g; // the number of garbage, starting from the '0'
				int b = now.b; // the number of the 'b(the next to garbage)', starting from the '0'

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (visited[nx][ny])
					continue;
				if (map[nx][ny] == 'F') {
					result_g = g;
					result_b = b;
					break loop;
				}
				if (map[nx][ny] == 'g')
					g++;
				if (map[nx][ny] == 'b')
					b++;
				visited[nx][ny] = true;
				pq.offer(new Node(nx, ny, g, b));
			}

		}

		System.out.println(result_g + " " + result_b);

	}

	private static void make_b() {
		for (int i = 0; i < list.size(); i++) {

			Point now = list.get(i);

			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (map[nx][ny] == '.')
					map[nx][ny] = 'b';
			}
		}
	}

}

// reference: https://lovelyunsh.tistory.com/53