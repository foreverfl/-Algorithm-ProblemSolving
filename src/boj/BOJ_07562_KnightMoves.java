package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_07562_KnightMoves {

	static class Knight {
		int x;
		int y;
		int cnt;

		Knight(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { +1, +2, +2, +1, -1, -2, -2, -1 };
	static int[] dy = { +2, +1, -1, -2, +2, +1, -1, -2 };
	static int I;
	static int start_x, start_y, target_x, target_y;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			I = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			start_x = Integer.parseInt(st.nextToken());
			start_y = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			target_x = Integer.parseInt(st.nextToken());
			target_y = Integer.parseInt(st.nextToken());

			map = new int[I][I];
			visited = new boolean[I][I];

			bfs(new Knight(start_x, start_y, 0), new Knight(target_x, target_y, 0));
		}
		
		System.out.println(sb.toString());
	}

	private static void bfs(Knight start, Knight target) {
		Queue<Knight> queue = new LinkedList<>();
		queue.add(start);
		visited[start.x][start.y] = true;

		while (!queue.isEmpty()) {
			Knight nxt = queue.poll();
			int x = nxt.x;
			int y = nxt.y;
			int cnt = nxt.cnt;

			if (x == target.x && y == target.y) {
				sb.append(cnt).append('\n');
			}

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < I && ny < I) {
					if (!visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.add(new Knight(nx, ny, cnt + 1));
					}
				}
			}
		}
	}

}
