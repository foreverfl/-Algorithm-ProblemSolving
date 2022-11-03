package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_07569_Tomato {

	static int[][][] map;
	static int[] dx = { 0, 0, -1, 1, 0, 0 };
	static int[] dy = { -1, 1, 0, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static Queue<tomato_07569> queue = new LinkedList<>();
	static int M, N, H;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());

					if (map[i][j][k] == 1)
						queue.add(new tomato_07569(i, j, k));
				}
			}
		}

		System.out.println(bfs());

	}

	private static int bfs() {
		while (!queue.isEmpty()) {
			tomato_07569 v = queue.poll();

			for (int i = 0; i < 6; i++) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];
				int nz = v.z + dz[i];

				if (nx >= 0 && ny >= 0 && nz >= 0 && nx < M && ny < N && nz < H) {
					if (map[nz][ny][nx] == 0) {

						queue.add(new tomato_07569(nz, ny, nx));

						map[nz][ny][nx] = map[v.z][v.y][v.x] + 1;
					}
				}
			}

		}

		int result = Integer.MIN_VALUE;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[i][j][k] == 0)
						return -1;
					
					result = Math.max(result, map[i][j][k]);
				}
			}
		}

		if (result == 1)
			return 0;
		else
			return (result - 1);
	}

}

class tomato_07569 {
	int x;
	int y;
	int z;

	tomato_07569(int z, int y, int x) {
		this.z = z;
		this.y = y;
		this.x = x;
	}
}

// reference: https://dragon-h.tistory.com/17