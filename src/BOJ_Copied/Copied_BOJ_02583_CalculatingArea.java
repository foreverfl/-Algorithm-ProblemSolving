package BOJ_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Copied_BOJ_02583_CalculatingArea {

	static int M, N, K, area;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			for (int i = startY; i < endY; i++) {
				for (int j = startX; j < endX; j++) {
					map[i][j] = 1;
				}
			}

		}
		// Though shape of map is different, its structure is same.

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					area = 0;
					dfs(i, j);
					count++;
					pq.add(area);
				}
			}
		}

		sb.append(count + "\n");
		while (!pq.isEmpty()) {
			sb.append(pq.poll() + " ");
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y) {
		map[x][y] = 1;
		area++;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
				continue;
			if (map[nextX][nextY] == 0) {
				dfs(nextX, nextY);
			}
		}
	}

}

// reference: https://codingtalk.tistory.com/63