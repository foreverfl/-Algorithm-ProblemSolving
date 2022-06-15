package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_03187_koze {

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
	static int wolf, sheep;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
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
				if (!visited[i][j]) {
					if (map[i][j] == 'k') {
						bfs(i, j, 1, 0);
					} else if (map[i][j] == 'v') {
						bfs(i, j, 0, 1);
					} else if (map[i][j] == '.') {
						bfs(i, j, 0, 0);
					}
				}
			}
		}

		System.out.print(sheep + " " + wolf);

	}

	public static void bfs(int x, int y, int s, int w) {

		Queue<Node> queue = new LinkedList<>();
		visited[x][y] = true;
		Node first = new Node(x, y);
		queue.offer(first);

		int k = s;
		int v = w;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue;

				if (visited[nx][ny])
					continue;

				if (map[nx][ny] == '.') {
					visited[nx][ny] = true;
					queue.offer(new Node(nx, ny));
				} else if (map[nx][ny] == 'k') {
					visited[nx][ny] = true;
					k++;
					queue.offer(new Node(nx, ny));
				} else if (map[nx][ny] == 'v') {
					visited[nx][ny] = true;
					v++;
					queue.offer(new Node(nx, ny));
				}
			}
		}

		if (k > v) {
			sheep = sheep + k;
		} else {
			wolf = wolf + v;
		}

	}

}
