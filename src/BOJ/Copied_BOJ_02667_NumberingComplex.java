package BOJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Copied_BOJ_02667_NumberingComplex {

	private static int dx[] = { 0, 0, 1, -1 };
	private static int dy[] = { 1, -1, 0, 0 };
	private static int[] aparts = new int[25 * 25];
	private static int N;
	private static int apartNum = 0; 
	private static boolean[][] visited = new boolean[25][25]; 
	private static int[][] map = new int[25][25]; 

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N][N];
		visited = new boolean[N][N];

		// input
		for (int i = 0; i < N; i++) {
			String input = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					apartNum++;
					bfs(i, j);
				}
			}
		}

		Arrays.sort(aparts);
		System.out.println(apartNum);

		for (int i = 0; i < aparts.length; i++) {
			if (aparts[i] == 0) {
			} else {
				System.out.println(aparts[i]);
			}
		}

	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;
		aparts[apartNum]++; // A starting value is '1'.

		while (!queue.isEmpty()) {
			int curX = queue.peek()[0]; // x
			int curY = queue.peek()[1]; // y
			queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if (map[nx][ny] == 1 && !visited[nx][ny]) {
						queue.add(new int[] { nx, ny });
						visited[nx][ny] = true;
						aparts[apartNum]++;
					}
				}
			}
		}
	}
}

// reference: https://n1tjrgns.tistory.com/245