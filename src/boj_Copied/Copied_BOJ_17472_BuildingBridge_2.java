package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_17472_BuildingBridge_2 {

	static class Node implements Comparable<Node> {
		int to;
		int from;
		int value;

		public Node(int to, int from, int value) {
			this.to = to;
			this.from = from;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}

	}

	static int N, M, landidx;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] parents;
	static Queue<int[]> queue;
	static PriorityQueue<Node> pq = new PriorityQueue<>();;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		landidx = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					nameIsland(j, i, landidx);
					landidx++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					makeBridge(j, i, map[i][j]);
				}
			}
		}

		landidx--;
		parents = new int[landidx];
		for (int i = 1; i < landidx; i++) {
			parents[i] = i;
		}
		int answer = findshortestPath();
		System.out.println(answer == 0 ? -1 : answer);

	}

	// coloring
	private static void nameIsland(int x, int y, int idx) {
		queue = new LinkedList<>();

		queue.add(new int[] { x, y });
		map[y][x] = idx;
		visited[y][x] = true;

		while (!queue.isEmpty()) {
			int[] nxt = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = nxt[0] + dx[i];
				int ny = nxt[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;

				if (visited[ny][nx])
					continue;

				if (map[ny][nx] == 1) {
					map[ny][nx] = idx;
					visited[ny][nx] = true;
					queue.add(new int[] { nx, ny });
				}
			}
		}
	}

	// linking
	private static void makeBridge(int x, int y, int idx) {
		queue = new LinkedList<>();
		visited = new boolean[N][M];

		for (int i = 0; i < 4; i++) {
			queue.add(new int[] { x, y, 0 });
			visited[y][x] = true;

			while (!queue.isEmpty()) {
				int[] nxt = queue.poll();

				int move = nxt[2];
				int nx = nxt[0] + dx[i];
				int ny = nxt[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;

				if (visited[ny][nx])
					continue;

				if (map[ny][nx] != idx) { // When finding another island
					if (map[ny][nx] != 0) {
						int from = idx - 1;
						int to = map[ny][nx] - 1;
						int bridgeLen = move;
						if (bridgeLen > 1) {
							pq.add(new Node(from, to, bridgeLen));
							break;
						}
					} else {
						visited[ny][nx] = true;
						queue.add(new int[] { nx, ny, move + 1 });
					}
				}
			}
			queue.clear();
		}
	}

	// choosing bridges
	private static int findshortestPath() {
		int sum = 0;
		int size = pq.size();
		for (int i = 0; i < size; i++) {
			Node node = pq.poll();
			int x = node.from;
			int y = node.to;

			if (find(x) != find(y)) {
				sum += node.value;
				union(x, y);
			}
		}

		int rx = parents[1];
		for (int i = 2; i < landidx; i++) {
			if (rx != find(parents[i])) {
				return 0;
			}
		}

		return sum;
	}

	private static int find(int x) {
		if (parents[x] == x)
			return x;
		int rx = find(parents[x]);
		return rx;

	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x < y) {
			parents[y] = x;
		} else {
			parents[x] = y;
		}
	}

}

// reference: https://loosie.tistory.com/262
