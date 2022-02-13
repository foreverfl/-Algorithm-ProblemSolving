package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_02606_Virus {
	static int C, N;
	static int node[][];
	static int check[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());

		node = new int[C + 1][C + 1];
		check = new int[C + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a][b] = 1;
			node[b][a] = 1;

		}

		bfs(1);
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();

		check[start] = 1;
		queue.offer(start);
		int cnt = 0;
		while (!queue.isEmpty()) {
			int x = queue.poll();

			for (int i = 1; i < node.length; i++) {
				if (node[x][i] == 1 && check[i] != 1) {
					queue.offer(i);
					check[i] = 1;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}

// reference: https://fbtmdwhd33.tistory.com/28