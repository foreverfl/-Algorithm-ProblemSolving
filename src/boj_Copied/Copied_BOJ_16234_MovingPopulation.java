package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_16234_MovingPopulation {

	static class Pointer {
		int x;
		int y;

		Pointer(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] visited;
	static int N, L, R;
	static ArrayList<Pointer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(move());

	}

	private static int move() { // repeating until population move doesn't occur
		int result = 0;
		while (true) {
			boolean canMove = false;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						int sum = bfs(i, j);
						if (list.size() > 1) {
							changelist(sum);
							canMove = true;
						}
					}
				}
			}
			if (!canMove)
				return result;

			result++;
		}
	}

	private static int bfs(int x, int y) { // returning population to move
		Queue<Pointer> queue = new LinkedList<>();
		list = new ArrayList<>();

		visited[x][y] = true;
		queue.add(new Pointer(x, y));
		list.add(new Pointer(x, y));

		int sum = map[x][y];
		while (!queue.isEmpty()) {
			Pointer current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if (!visited[nx][ny]) {
						int diff = Math.abs(map[current.x][current.y] - map[nx][ny]);

						if (L <= diff && diff <= R) {
							queue.add(new Pointer(nx, ny));
							list.add(new Pointer(nx, ny));
							sum += map[nx][ny];
							visited[nx][ny] = true;
						}
					}
				}
			}
		}
		return sum;
	}

	private static void changelist(int sum) {
		int avg = sum / list.size();
		for (Pointer n : list) { // using object list to save coordinates
			map[n.x][n.y] = avg; 
		}
	}

}

// reference: https://moonsbeen.tistory.com/259