package boj_Copied;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Copied_BOJ_17025_IcyPerimeter {

	private static int[] dx = { 1, 0, 0, -1 };
	private static int[] dy = { 0, 1, -1, 0 };
	private static int N;
	private static char[][] arr;
	private static boolean[][] visit;
	private static int size;
	private static int perimeter;

	public static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visit = new boolean[N][N];
		size = -1;
		perimeter = 987654321;
		for (int i = 0; i < N; i++)
			Arrays.fill(visit[i], false);

		for (int i = 0; i < N; i++)
			arr[i] = br.readLine().toCharArray();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				bfs(j, i);
		}
		bw.write(Integer.toString(size) + " " + Integer.toString(perimeter));
		bw.flush();
	}

	private static void bfs(int x, int y) {
		if (visit[y][x] || arr[y][x] != '#')
			return;
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(x, y));
		visit[y][x] = true;
		int res = 1;
		int res2 = 0;
		while (!queue.isEmpty()) {
			int curx = queue.peek().x;
			int cury = queue.peek().y;
			queue.poll();
			int cnt = 4; // basic perimeter of one
			for (int i = 0; i < 4; i++) {
				int nx = curx + dx[i];
				int ny = cury + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[ny][nx] == '#')
					cnt--;
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[ny][nx] && arr[ny][nx] == '#') {
					queue.add(new Pair(nx, ny));
					visit[ny][nx] = true;
					res++;
				}
			}
			res2 += cnt;
		}
		if (size < res) {
			size = res;
			perimeter = res2;
		} else if (size == res)
			perimeter = Math.min(res2, perimeter);
	}
}

// reference: https://velog.io/@pjh612/%EB%B0%B1%EC%A4%80-17025%EB%B2%88-Icy-Perimeter