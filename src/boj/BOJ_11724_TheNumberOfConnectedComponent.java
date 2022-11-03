package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724_TheNumberOfConnectedComponent {

	static int N, M;
	static boolean node[][];
	static boolean check[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		node = new boolean[N + 1][N + 1];
		check = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			node[x][y] = node[y][x] = true;
			
		}

		int cnt = 0;
		for (int i = 1; i <= N; i++) { // The 'i<N' causes error to occur.
			if (!check[i]) {
				bfs(i);
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	private static void bfs(int input) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(input);
		check[input] = true;

		while (!queue.isEmpty()) {
			int x = queue.poll();

			for (int i = 1; i <= N; i++) {
				if (node[x][i] && !check[i]) {
					check[i] = true;
					queue.offer(i);					
				}
			}
		}

	}

}
