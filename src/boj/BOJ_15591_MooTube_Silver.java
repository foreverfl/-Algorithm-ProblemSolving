package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15591_MooTube_Silver {

	static class Node {
		int n; // number
		int w; // weight

		Node(int n, int w) {
			this.n = n;
			this.w = w;
		}
	}

	static int N, Q;
	static List<List<Node>> list = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		// init
		for (int i = 0; i <= N; i++) {
			List<Node> tmp = new ArrayList<>();
			list.add(tmp);
		}

		int repeat = N - 1;
		while (repeat-- > 0) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			list.get(p).add(new Node(q, r));
			list.get(q).add(new Node(p, r));
		}

		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			sb.append(bfs(k, v)).append('\n');
		}

		System.out.print(sb.toString());
	}

	public static int bfs(int k, int v) {
		int res = 0;

		visited = new boolean[N + 1];
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(v, 0));
		visited[v] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			for (int i = 0; i < list.get(now.n).size(); i++) {
				if (!visited[list.get(now.n).get(i).n]) {
					if (list.get(now.n).get(i).w >= k) {
						visited[list.get(now.n).get(i).n] = true;
						queue.offer(new Node(list.get(now.n).get(i).n, list.get(now.n).get(i).w));
						res++;
					}
				}
			}
		}

		return res;

	}

}
