package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_03184_Ovce {

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int R, C;
	static int S, W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'o' && !visited[i][j]) {
					bfs(i, j, 1, 0);
				} else if (map[i][j] == 'v' && !visited[i][j]) {
					bfs(i, j, 0, 1);
				} else if (map[i][j] == '#') {
					continue;
				} else if (map[i][j] == '.' && !visited[i][j]) {
					bfs(i, j, 0, 0);
				}
			}
		}

		System.out.println(S + " " + W);

	}

	private static void bfs(int x, int y, int s, int w) {

		Queue<Node> queue = new LinkedList<>();

		visited[x][y] = true;
		Node first = new Node(x, y);

		queue.offer(first);

		int sheep = s;
		int wolf = w;

		while (!queue.isEmpty()) {

			Node nxt = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = nxt.x + dx[i];
				int ny = nxt.y + dy[i];

				if (nx >= R || ny >= C || nx < 0 || ny < 0)
					continue;

				if (visited[nx][ny])
					continue;

				if (map[nx][ny] == 'o') {
					visited[nx][ny] = true;
					sheep++;
					queue.offer(new Node(nx, ny));
				} else if (map[nx][ny] == 'v') {
					visited[nx][ny] = true;
					wolf++;
					queue.offer(new Node(nx, ny));
				} else if (map[nx][ny] == '#') {
					visited[nx][ny] = true;
					continue;
				} else if (map[nx][ny] == '.') {
					visited[nx][ny] = true;
					queue.offer(new Node(nx, ny));
				}

			}
		}

		if (wolf >= sheep) {
			W += wolf;
		} else {
			S += sheep;
		}
	}

}
