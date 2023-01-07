package boj_Copied;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Copied_BOJ_05719_AlmostShortestPath {

	static class Pair implements Comparable<Pair> {

		int idx, weight;

		Pair(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public int compareTo(Pair o) {

			return this.weight - o.weight;
		}
	}

	static int N, M;
	static int[] dist;
	static List<Pair>[] list;
	static boolean[][] check;
	static List<Integer>[] parent;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0)
				break;

			dist = new int[N];
			list = new ArrayList[N];
			parent = new ArrayList[N];
			check = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				list[i] = new ArrayList<>();
				parent[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int U = Integer.parseInt(st.nextToken());
				int V = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());

				list[U].add(new Pair(V, P));

			}

			dijkstra(S, D); // the first Dijkstra
			backTracking(S, D);
			dijkstra(S, D); // the second Dijkstra

			if (dist[D] == Integer.MAX_VALUE)
				bw.write(-1 + "\n");
			else
				bw.write(dist[D] + "\n");
		}

		bw.flush();

	}

	private static void backTracking(int S, int node) {

		if (node == S)
			return;

		for (int n : parent[node]) {

			if (!check[n][node]) {
				check[n][node] = true;
				backTracking(S, n);
			}
		}
	}

	private static void dijkstra(int S, int D) {

		for (int i = 0; i < N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		dist[S] = 0;
		pq.offer(new Pair(S, dist[S]));

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (dist[pair.idx] < pair.weight)
				continue;

			for (Pair new_pair : list[pair.idx]) {

				if (!check[pair.idx][new_pair.idx]) {

					if (dist[new_pair.idx] == dist[pair.idx] + new_pair.weight) {
						parent[new_pair.idx].add(pair.idx);
					}

					else if (dist[new_pair.idx] > dist[pair.idx] + new_pair.weight) {

						dist[new_pair.idx] = dist[pair.idx] + new_pair.weight;
						parent[new_pair.idx].clear();
						parent[new_pair.idx].add(pair.idx);
						pq.offer(new Pair(new_pair.idx, dist[new_pair.idx]));
					}
				}
			}
		}
	}

}

// reference: https://devfunny.tistory.com/641
