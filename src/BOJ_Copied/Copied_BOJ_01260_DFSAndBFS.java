package BOJ_Copied;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Copied_BOJ_01260_DFSAndBFS {

	static int[][] check;
	static boolean[] checked;
	static int N;
	static int M;
	static int start;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // vertex
		M = sc.nextInt(); // edge
		start = sc.nextInt();

		check = new int[1001][1001]; // The value of the 'check[][]' is '1001' to accept coordinates as it is.
		checked = new boolean[1001];

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			check[x][y] = check[y][x] = 1;
		}

		dfs(start);

		checked = new boolean[1001]; // initialization
		System.out.println();

		bfs();
	}

	// using a recursive function
	public static void dfs(int i) {
		checked[i] = true;
		System.out.print(i + " ");

		for (int j = 1; j <= N; j++) {
			if (check[i][j] == 1 && checked[j] == false) {
				dfs(j);
			}
		}
	}

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		checked[start] = true;
		System.out.print(start + " ");

		while (!queue.isEmpty()) {
			int temp = queue.poll();

			for (int j = 1; j <= N; j++) {
				if (check[temp][j] == 1 && checked[j] == false) {
					queue.offer(j);
					checked[j] = true;
					System.out.print(j + " ");
				}
			}
		}
	}
}

// reference: https://m.blog.naver.com/lm040466/221787478911