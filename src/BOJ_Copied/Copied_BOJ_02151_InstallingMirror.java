package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Copied_BOJ_02151_InstallingMirror {

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int dir;
		int cnt;

		public Node(int x, int y, int dir, int cnt) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			return this.cnt - o.cnt;
		}
	}

	static char[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int N;
	static int sx, sy, ex, ey; // point of door

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new char[N][N];

		int idx = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '#') {
					if (idx == 0) {
						sx = i;
						sy = j;
					} else {
						ex = i;
						ey = j;
					}
					idx++;
				}
			}
		}

		bfs();
	}

	public static void bfs() {
		// PriorityQueue is used to get a minimum value.
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[][][] visited = new boolean[N][N][4];

		for (int i = 0; i < 4; i++) {
			pq.add(new Node(sx, sy, i, 0));
		}

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			int x = now.x;
			int y = now.y;
			int dir = now.dir;
			int cnt = now.cnt;

			visited[x][y][dir] = true;

			if (x == ex && y == ey) {
				System.out.print(cnt);
				return;
			}

			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny][dir] && map[nx][ny] != '*') {
				if (map[nx][ny] == '!') {
					// right
					int nDir = (dir + 3) % 4;
					pq.add(new Node(nx, ny, nDir, cnt + 1));

					// left
					nDir = (dir + 1) % 4;
					pq.add(new Node(nx, ny, nDir, cnt + 1));
				}

				pq.add(new Node(nx, ny, dir, cnt));
			}
		}

	}

}

// reference: https://velog.io/@minchae75/%EB%B0%B1%EC%A4%80-Java-2151%EB%B2%88-%EA%B1%B0%EC%9A%B8-%EC%84%A4%EC%B9%98
