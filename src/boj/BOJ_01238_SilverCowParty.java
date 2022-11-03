package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_01238_SilverCowParty {

	static class Node implements Comparable<Node> {
		int idx;
		int cost;

		Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	static final int INF = 987654321;
	static int[] go_dist;
	static int[] back_dist;
	static ArrayList<ArrayList<Node>> go = new ArrayList<>();
	static ArrayList<ArrayList<Node>> back = new ArrayList<>();
	static int N, M, X;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		go_dist = new int[N + 1];
		back_dist = new int[N + 1];
		Arrays.fill(go_dist, INF);
		Arrays.fill(back_dist, INF);

		for (int i = 0; i <= N; i++) {
			go.add(new ArrayList<>());
			back.add(new ArrayList<>());
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			go.get(A).add(new Node(B, T));
			back.get(B).add(new Node(A, T));
		}

		dijkstra_go(X);
		dijkstra_back(X);

		int ans = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, go_dist[i] + back_dist[i]);
		}

		System.out.print(ans);

	}

	private static void dijkstra_go(int num) {

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.offer(new Node(num, 0));
		go_dist[num] = 0;

		while (!pq.isEmpty()) {

			Node node = pq.poll();

			int cost = node.cost;
			int idx = node.idx;

			if (go_dist[idx] < cost)
				continue;

			for (int i = 0; i < go.get(idx).size(); i++) {
				int tmp = go_dist[idx] + go.get(idx).get(i).cost;

				if (tmp < go_dist[go.get(idx).get(i).idx]) {
					go_dist[go.get(idx).get(i).idx] = tmp;
					pq.offer(new Node(go.get(idx).get(i).idx, tmp));
				}
			}
		}

	}

	private static void dijkstra_back(int num) {

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.offer(new Node(num, 0));
		back_dist[num] = 0;

		while (!pq.isEmpty()) {

			Node node = pq.poll();

			int cost = node.cost;
			int idx = node.idx;

			if (back_dist[idx] < cost)
				continue;

			for (int i = 0; i < back.get(idx).size(); i++) {
				int tmp = back_dist[idx] + back.get(idx).get(i).cost;

				if (tmp < back_dist[back.get(idx).get(i).idx]) {
					back_dist[back.get(idx).get(i).idx] = tmp;
					pq.offer(new Node(back.get(idx).get(i).idx, tmp));
				}
			}
		}

	}

}
