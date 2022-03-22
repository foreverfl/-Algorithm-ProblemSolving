package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Copied_BOJ_01967_DiameterOfTree {

	static ArrayList<Node> list[];
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

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[parent].add(new Node(child, weight));
			list[child].add(new Node(parent, weight));
		}

		visited = new boolean[n + 1];
		visited[1] = true;
		dfs(1, 0); // finding a maximum index

		visited = new boolean[n + 1];
		visited[max_idx] = true;
		dfs(max_idx, 0);
		System.out.println(max);

	}

	public static void dfs(int idx, int cnt) {
		if (max < cnt) {
			max = cnt;
			max_idx = idx;
		}

		for (Node nxt : list[idx]) {
			if (!visited[nxt.idx]) {
				visited[nxt.idx] = true;
				dfs(nxt.idx, cnt + nxt.cnt);
			}
		}

	}
}

class Node {
	int idx, cnt;

	Node(int idx, int cnt) {
		this.idx = idx;
		this.cnt = cnt;
	}
}

// reference: https://suhyeokeee.tistory.com/175