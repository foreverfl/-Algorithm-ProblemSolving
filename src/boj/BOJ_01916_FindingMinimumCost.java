package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_01916_FindingMinimumCost {

	static class Vertex implements Comparable<Vertex> {
		int vertex;
		int weight;

		Vertex(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return weight - o.weight;
		}
	}

	static ArrayList<Vertex>[] graph;
	static boolean[] visited;
	static int[] distance;
	static int N, M, start, target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		distance = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph[x].add(new Vertex(y, weight));
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());

		dijkstra(start);

		System.out.println(distance[target]);

	}

	private static void dijkstra(int start) {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.add(new Vertex(start, 0));
		distance[start] = 0;

		while (!pq.isEmpty()) {
			Vertex current = pq.poll();
			int vertex = current.vertex;

			if (visited[vertex] == true)
				continue;

			visited[vertex] = true;

			for (Vertex nxt : graph[vertex]) {
				if (distance[nxt.vertex] > distance[vertex] + nxt.weight) {
					distance[nxt.vertex] = distance[vertex] + nxt.weight;
					pq.add(new Vertex(nxt.vertex, distance[nxt.vertex]));
				}
			}

		}
	}

}
