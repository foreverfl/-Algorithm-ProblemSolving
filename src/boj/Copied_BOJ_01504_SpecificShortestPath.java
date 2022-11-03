package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Copied_BOJ_01504_SpecificShortestPath {

	static class Node implements Comparable<Node> {
		int n, w;

		Node(int n, int w) {
			this.n = n;
			this.w = w;
		}

		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	static final int INF = 200000000;
	static List<List<Node>> list = new ArrayList<>();
	static int[] dist;
	static int N, E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		dist = new int[N + 1];
		Arrays.fill(dist, INF);

		for (int i = 0; i <= N; i++) {
			List<Node> tmp = new ArrayList<>();
			list.add(tmp);
		}

		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));

		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int res1 = 0;
		res1 += dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, N);

		int res2 = 0;
		res2 += dijkstra(1, v2);
		res2 += dijkstra(v2, v1);
		res2 += dijkstra(v1, N);

		int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

		System.out.print(ans);
	}

	public static int dijkstra(int s, int e) {
		Arrays.fill(dist, INF);

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(s, 0));
		dist[s] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (dist[now.n] < now.w) {
				continue;
			}

			for (Node node : list.get(now.n)) {
				if (dist[node.n] > dist[now.n] + node.w) {
					dist[node.n] = dist[now.n] + node.w;

					pq.offer(new Node(node.n, dist[node.n]));
				}
			}
		}
		
		return dist[e];

	}

}

// reference: https://steady-coding.tistory.com/82
