package boj;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solving_BOJ_09186_TheSameGame {

	private static class Cluster implements Comparable<Cluster> {
		private int x;
		private int y;
		private int size;
		private char color;

		public Cluster() {

		}

		public Cluster(int x, int y, int size, char color) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.color = color;
		}

		@Override
		public int compareTo(Cluster o) {
			return o.size - this.size;
		}

		@Override
		public String toString() {
			return "Cluster [x=" + x + ", y=" + y + ", size=" + size + ", color=" + color + "]";
		}

	}

	private static List<Cluster> clusters = new ArrayList<>();

	private static int T;
	private static char[][] map;
	private static boolean[][] visited;
	private static int score;
	private static int totalSize;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		int game = 0;
		while (T-- > 0) {
			sb.append("Game " + ++game + ":\n\n");
			totalSize = 150;
			score = 0;
			map = new char[10 + 1][15 + 1];

			// input
			br.readLine();

			for (int i = 1; i <= 10; i++) {
				String str = br.readLine();
				for (int j = 1; j <= 15; j++) {
					map[i][j] = str.charAt(j - 1);
				}
			}

			int move = 0;
			while (true) {

				print();
				clusters.clear();
				visited = new boolean[10 + 1][15 + 1];

				// left -> right
				// bottom -> top
				for (int i = 10; i >= 1; i--) {
					for (int j = 1; j <= 15; j++) {
						if (map[i][j] != 'O')
							findLargestCluster(i, j);
					}
				}

				Collections.sort(clusters);

				if (isOver())
					break;

				Cluster clusterNow = clusters.get(0);
				visited = new boolean[10 + 1][15 + 1];
				removeCluster(clusterNow);
				totalSize -= clusterNow.size;

				int scoreTmp = 0;
				if (clusterNow.size != 1)
					scoreTmp = calcScore(clusterNow.size);

				score += scoreTmp;
				if (totalSize == 0) {
					score += 1000;
				}

				shiftToBottom();
				shiftToLeft();

				if (score != 0) {
					sb.append("Move " + ++move + " at (" + (11 - clusterNow.x) + "," + (clusterNow.y) + "): removed "
							+ clusterNow.size + " balls of color " + clusterNow.color + ", got " + scoreTmp
							+ " points.\n");
				}

			}

			int remains = 0;
			if (clusters.isEmpty()) {
				sb.append("Final score: " + score + ", with " + remains + " balls remaining.\n\n");

			} else {
				for (int i = 0; i < clusters.size(); i++) {
					remains += clusters.get(i).size;
				}
				sb.append("Final score: " + score + ", with " + remains + " balls remaining.\n\n");
			}

		}

		System.out.println(sb.toString().trim());
	}

	private static void findLargestCluster(int x, int y) {
		// bfs
		Cluster cluster = new Cluster();
		int tmpX = x;
		int tmpY = y;
		cluster.size = 1;
		cluster.color = map[x][y];
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			if(tmpX <= now.x) {
				tmpX = now.x;
			}
			if(tmpY >= now.y) {
				tmpY = now.y;
			}
			char color = map[now.x][now.y];

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 1 || nx > 10 || ny < 1 || ny > 15)
					continue;

				if (!visited[nx][ny] && map[nx][ny] == color) {
					visited[nx][ny] = true;
					queue.add(new Point(nx, ny));
					cluster.size++;
				}
			}
		}

		cluster.x = tmpX;
		cluster.y = tmpY;
		clusters.add(cluster);

	}

	private static void removeCluster(Cluster cluster) {
		// bfs
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(cluster.x, cluster.y));
		visited[cluster.x][cluster.y] = true;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			char color = cluster.color;

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 1 || nx > 10 || ny < 1 || ny > 15)
					continue;

				if (!visited[nx][ny] && map[nx][ny] == color) {
					visited[nx][ny] = true;
					map[nx][ny] = 'O';
					queue.add(new Point(nx, ny));
				}
			}
		}

		map[cluster.x][cluster.y] = 'O';
	}

	private static int calcScore(int size) {
		int result = (int) Math.pow((size - 2), 2);

		return result;
	}

	private static void shiftToBottom() {
		for (int i = 1; i <= 15; i++) {
			int cnt = 0;
			int idx = 0;
			List<Character> tmp = new ArrayList<>();
			for (int j = 10; j >= 1; j--) {
				tmp.add(map[j][i]);
			}

			for (int j = 0; j < tmp.size(); j++) {
				if (tmp.get(j) == 'O') {
					cnt++;
					tmp.remove(j);
					j = -1;
				}
			}

			while (cnt-- > 0) {
				tmp.add('O');
			}

			for (int j = 10; j >= 1; j--) {
				map[j][i] = tmp.remove(idx);
			}
		}
	}

	private static void shiftToLeft() {
		for (int i = 1; i <= 14; i++) {
			boolean nowFlag = false;
			boolean nextFlag = false;
			List<Character> now = new ArrayList<>();
			List<Character> next = new ArrayList<>();
			for (int j = 1; j <= 10; j++) {
				now.add(map[j][i]);
				next.add(map[j][i + 1]);
			}

			for (int j = 0; j < now.size(); j++) {
				if (!now.contains('R') && !now.contains('G') && !now.contains('B')) {
					nowFlag = true;
					break;
				}
			}

			for (int j = 0; j < next.size(); j++) {
				if (next.contains('R') || next.contains('G') || next.contains('B')) {
					nextFlag = true;
					break;
				}
			}

			if (nowFlag && nextFlag) {
				int idx = 0;
				for (int j = 1; j <= 10; j++) {
					map[j][i] = next.get(idx++);
					map[j][i + 1] = 'O';
				}
				i = 1;
			}

		}
	}

	private static boolean isOver() {

		if (clusters.isEmpty()) {
			return true;
		} else if (clusters.get(0).size == 1) {
			return true;
		}
		return false;
	}

	private static void print() {
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 15; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("===================");
	}

}
