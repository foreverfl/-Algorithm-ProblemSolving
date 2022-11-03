package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Copied_BOJ_18352_FindingCityOfSpecificDistance {

	static class Node implements Comparable<Node> {
		int idx;
		int dist;

		Node(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}

	static int N, M, K, X;
	static int dist[];
	static final int INF = (int) Integer.MAX_VALUE;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		dist = new int[N + 1];
		Arrays.fill(dist, INF);

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int cost = 1;
			list.get(A).add(new Node(B, cost));

		}

		dijkstra(X);

		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (K == dist[i])
				res.add(i);
		}

		if (res.isEmpty())
			System.out.println(-1);
		else {
			for (Integer r : res) {
				System.out.println(r);
			}
		}

	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (dist[now.idx] < now.dist)
				continue;

			for (int i = 0; i < list.get(now.idx).size(); i++) {
				int cost = dist[now.idx] + list.get(now.idx).get(i).dist;
				if (cost < dist[list.get(now.idx).get(i).idx]) {
					dist[list.get(now.idx).get(i).idx] = cost;
					pq.offer(new Node(list.get(now.idx).get(i).idx, cost));
				}
			}
		}
	}

}

// reference: https://velog.io/@admin1194/%EB%B0%B1%EC%A4%8018352%ED%8A%B9%EC%A0%95%EA%B1%B0%EB%A6%AC%EC%9D%98-%EB%8F%84%EC%8B%9C%EC%B0%BE%EA%B8%B0