package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_01167_DiameterOfTree {

	static ArrayList<Node_01167> list[];
	static boolean visited[];
	static int n;
	static int max = 0, max_idx = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		list = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());

			while (true) {
				int child = Integer.parseInt(st.nextToken());
				
				if (child == -1)
					break;
				
				int weight = Integer.parseInt(st.nextToken());

				list[parent].add(new Node_01167(child, weight));
				list[child].add(new Node_01167(parent, weight));
			}
		}

		visited = new boolean[n + 1];
		visited[1] = true;
		dfs(1, 0); // finding a maximum index

		visited = new boolean[n + 1];
		visited[max_idx] = true;
		dfs(max_idx, 0);
		System.out.println(max);

	}

	public static void dfs(int idx, int weight) {
		if (max < weight) {
			max = weight;
			max_idx = idx;
		}

		for (Node_01167 nxt : list[idx]) {
			if (!visited[nxt.idx]) {
				visited[nxt.idx] = true;
				dfs(nxt.idx, weight + nxt.weight);
			}
		}

	}
}

class Node_01167 {
	int idx, weight;

	Node_01167(int idx, int weight) {
		this.idx = idx;
		this.weight = weight;
	}
}