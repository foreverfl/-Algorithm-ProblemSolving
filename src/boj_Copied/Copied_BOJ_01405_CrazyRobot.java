package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01405_CrazyRobot {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static double[] percent;
	static boolean[][] visited;
	static int N;
	static double result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		percent = new double[4];
		for (int i = 0; i < 4; i++) {
			percent[i] = Integer.parseInt(st.nextToken()) * 0.01;
		}

		visited = new boolean[30][30]; // Starting point is (15, 15).
		result = 0;
		dfs(15, 15, 0, 1);
		System.out.println(result);
	}

	public static void dfs(int x, int y, int depth, double total) {
		if (depth == N) {
			result += total;
			return;
		}

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 && ny < 0 && nx >= 30 && ny >= 30)
				continue;

			if (visited[nx][ny] == false) {
				visited[nx][ny] = true;
				dfs(nx, ny, depth + 1, total * percent[i]);
				visited[nx][ny] = false;
			}
		}

	}

}

// reference: https://moonsbeen.tistory.com/173
