package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Copied_BOJ_01240_DistanceBetweenNodes {

	static class Node {
		int vertex;
		int weight;

		Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}

	static ArrayList<Node>[] graph;
	static boolean[] visited;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		int repeat = N - 1;
		while (repeat-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, w));
			graph[b].add(new Node(a, w));
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());

			dfs(start, target, -1, 0);
			sb.append(ans).append('\n');

			visited = new boolean[N + 1];			
		}

		System.out.println(sb.toString());
	}

	private static void dfs(int start, int target, int current, int result) {
		if (start == target) {
			ans = result;
		}

		for (Node nxt : graph[start]) {
			int vertex = nxt.vertex;
			int weight = nxt.weight;

			if (vertex != current) // excluding current node
				dfs(vertex, target, start, result + weight);
		}

	}

}

// reference: https://loosie.tistory.com/517