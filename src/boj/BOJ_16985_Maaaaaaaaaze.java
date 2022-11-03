package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16985_Maaaaaaaaaze {

	static class Node {
		int x;
		int y;
		int z;
		int cnt;

		Node(int x, int y, int z, int cnt) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.cnt = cnt;
		}

	}

	static int[][][] origin = new int[5][5][5];
	static int[][][] copied_1 = new int[5][5][5]; // rotation
	static int[][][] copied_2 = new int[5][5][5]; // selection
	static int dx[] = { -1, 1, 0, 0, 0, 0 };
	static int dy[] = { 0, 0, -1, 1, 0, 0 };
	static int dz[] = { 0, 0, 0, 0, -1, 1 };

	static int[] permutation = new int[5];
	static boolean[] checked = new boolean[5];
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 5; k++) {
					origin[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		rotateMap(0, 5, 5);

		if (ans == Integer.MAX_VALUE) {
			System.out.print(-1);
		} else
			System.out.print(ans);

	}

	public static void selectMap(int depth) {
		if (depth == 5) {
			if (copied_2[0][0][0] == 1 && copied_2[4][4][4] == 1) {
				ans = Math.min(ans, bfs(0, 0, 0));
			}
		}

		for (int i = 0; i < 5; i++) {
			if (!checked[i]) {
				checked[i] = true;
				copied_2[depth] = copied_1[i];
				selectMap(depth + 1);
				checked[i] = false;
			}
		}
	}

	public static void rotateMap(int depth, int n, int r) {
		if (depth == r) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					copied_1[i][j] = Arrays.copyOf(origin[i][j], 5);
				}
			}

			// rotation
			for (int i = 0; i < 5; i++) {
				copied_1[i] = rotate(permutation[i], copied_1[i]);
			}

			// search
			selectMap(0);

			return;
		}

		for (int i = 0; i < 4; i++) { // 0 ~ 3 -> rotation direction
			permutation[depth] = i;
			rotateMap(depth + 1, n, r);
		}

	}

	public static int[][] rotate(int num, int[][] map) {

		while (num-- > 0) {

			int[][] tmp = new int[5][5];

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					tmp[j][5 - 1 - i] = map[i][j];
				}
			}

			map = tmp;
		}

		return map;
	}

	public static int bfs(int x, int y, int z) {
		boolean[][][] visited = new boolean[5][5][5];
		Queue<Node> queue = new LinkedList<>();

		queue.offer(new Node(0, 0, 0, 0));
		visited[x][y][z] = true;

		while (!queue.isEmpty()) {

			Node now = queue.poll();
			// arriving
			if (now.x == 4 && now.y == 4 && now.z == 4) {
				return now.cnt;
			}

			for (int i = 0; i < 6; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				int nz = now.z + dz[i];

				if (isRange(nx, ny, nz) && !visited[nx][ny][nz]) {

					if (copied_2[nx][ny][nz] == 1) {
						visited[nx][ny][nz] = true;
						queue.offer(new Node(nx, ny, nz, now.cnt + 1));
					}
				}
			}
		}
		return Integer.MAX_VALUE;

	}

	public static boolean isRange(int x, int y, int z) {
		if (x >= 0 && y >= 0 && z >= 0 && x < 5 && y < 5 && z < 5)
			return true;

		return false;
	}

}
