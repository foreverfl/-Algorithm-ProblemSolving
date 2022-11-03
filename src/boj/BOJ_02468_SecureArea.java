package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_02468_SecureArea {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dX = { 0, 0, 1, -1 };
	static int[] dY = { 1, -1, 0, 0 };
	static int height = 0; // initial value
	static Integer[] cnt = new Integer[100]; // counting per height

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		// initialization wrapper class as '1'
		for (int i = 0; i < cnt.length; i++) {
			cnt[i] = 0;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (height++ < 100) {
			visited = new boolean[N][N]; // initialization whether to visit or not
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > height && !visited[i][j]) {
						bfs(i, j, height);
						cnt[height - 1]++; // The 'cnt[i]' start from '0'.
					}
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] > max)
				max = cnt[i];
		}
		
		if (max == 0) { // if no area is flooded.
			max = 1;
		}

		sb.append(max);
		System.out.println(sb);
	}

	private static void bfs(int x, int y, int target) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curY = queue.peek()[1];
			queue.poll();

			for (int i = 0; i < 4; i++) {
				int nX = curX + dX[i];
				int nY = curY + dY[i];

				if (nX >= 0 && nY >= 0 && nX < N && nY < N) {
					if (map[nX][nY] > target && !visited[nX][nY]) {
						queue.add(new int[] { nX, nY });
						visited[nX][nY] = true;

					}
				}
			}

		}

	}

}
