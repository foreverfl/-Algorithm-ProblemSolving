package boj_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Copied_BOJ_02307_InspectingRoad {

	static class Edge implements Comparable<Edge> {
		int to;
		int w;

		Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dist = new int[N + 1];
		int[] path = new int[N + 1];
		ArrayList<Edge>[] arr = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[u].add(new Edge(v, w));
			arr[v].add(new Edge(u, w));
		}

		int min;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[1] = 0;
		pq.offer(new Edge(1, 0));
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			for (Edge e : arr[now.to]) {
				if (dist[e.to] > dist[now.to] + e.w) {
					dist[e.to] = dist[now.to] + e.w;

					path[e.to] = now.to; // updating path
					// path[i] = j => visiting j node -> i node
					pq.offer(new Edge(e.to, dist[e.to]));
				}
			}
		}
		min = dist[N];

		int to = N;
		int max = 0;
		do {
			int from = path[to];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[1] = 0;
			pq.offer(new Edge(1, 0));
			while (pq.size() > 0) {
				Edge now = pq.poll();
				for (Edge e : arr[now.to]) {
					if (from != now.to || to != e.to) { // excluding weight between the from and the to
						if (dist[e.to] > dist[now.to] + e.w) {
							dist[e.to] = dist[now.to] + e.w;
							pq.offer(new Edge(e.to, dist[e.to]));
						}
					}
				}
			}
			if (dist[N] > max)
				max = dist[N];
			to = from;
		} while (to != 1);

		if (max == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(max - min);
	}

}

// reference: https://medium.com/%EC%8A%AC%EA%B8%B0%EB%A1%9C%EC%9A%B4-%EA%B0%9C%EB%B0%9C%EC%83%9D%ED%99%9C/%EB%B0%B1%EC%A4%80-2307-%EB%8F%84%EB%A1%9C-%EA%B2%80%EB%AC%B8-java-316879f6341e