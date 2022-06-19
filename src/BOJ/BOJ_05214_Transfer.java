package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_05214_Transfer {

	static class Node {
		int num;
		int cnt;

		Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	static List<List<Node>> list;
	static boolean[] visited;
	static int N, K, M;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			List<Node> tmp = new ArrayList<>();
			list.add(tmp);
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int tmp = Integer.parseInt(st.nextToken());
				list.get(i).add(new Node(tmp, 0));
			}
		}

		bfs();
	}

	public static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(1, 0));
		visited[1] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			if (now.num == N) {
				ans = now.cnt;
				return;
			}

			for (int i = 0; i < K; i++) {
				Node nxt = list.get(now.num).get(i);
				int cur = nxt.num;

				if (!visited[cur]) {
					visited[cur] = true;
					queue.offer(new Node(cur, nxt.cnt + 1));
				}
			}
		}
	}

}
