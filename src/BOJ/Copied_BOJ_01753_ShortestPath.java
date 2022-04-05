package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Copied_BOJ_01753_ShortestPath {

	static class Vertex implements Comparable<Vertex> {
		int v;
		int weight;

		Vertex(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return weight - o.weight;
		}
	}

	static ArrayList<Vertex>[] graph;
	static int[] distance;
	static int V, E, K;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		K = Integer.parseInt(br.readLine());

		graph = new ArrayList[V + 1];
		distance = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}

		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph[x].add(new Vertex(y, weight));
		}

		dijkstra(K);

		for (int i = 1; i <= V; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				sb.append("INF").append('\n');
			} else {
				sb.append(distance[i]).append('\n');
			}
		}

		System.out.println(sb.toString());

	}

	private static void dijkstra(int start) {
		PriorityQueue<Vertex> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[V + 1];
		queue.add(new Vertex(start, 0));
		distance[start] = 0;

		while (!queue.isEmpty()) {
			Vertex current = queue.poll();
			int vertex = current.v;

			if (visited[vertex] == true)
				continue;
			
			visited[vertex] = true;

			for (Vertex nxt : graph[vertex]) {
				if (distance[nxt.v] > distance[vertex] + nxt.weight) {
					distance[nxt.v] = distance[vertex] + nxt.weight;
					queue.add(new Vertex(nxt.v, distance[nxt.v]));
				}
			}

		}

	}

}

// reference: https://dragon-h.tistory.com/20
