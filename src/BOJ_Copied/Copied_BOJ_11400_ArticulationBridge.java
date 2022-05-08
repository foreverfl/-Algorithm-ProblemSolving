package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Copied_BOJ_11400_ArticulationBridge {

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int count = 1;
	static int[] order;
	static ArrayList<ArrayList<Integer>> graph;
	static ArrayList<Node> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int V = Integer.valueOf(st.nextToken());
		int E = Integer.valueOf(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph.get(A).add(B);
			graph.get(B).add(A);
		}

		order = new int[V + 1];
		ans = new ArrayList<>();

		for (int i = 1; i <= V; i++) {
			if (order[i] == 0) {
				dfs(i, 0, graph);
			}
		}

		Collections.sort(ans, (a1, a2) -> (a1.x == a2.x) ? a1.y - a2.y : a1.x - a2.x); // comparator by stream

		sb.append(ans.size() + "\n");

		for (int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i).x + " " + ans.get(i).y + "\n");
		}

		System.out.println(sb.toString());

	}

	public static int dfs(int vertex, int parent, ArrayList<ArrayList<Integer>> arraylist) {
		order[vertex] = count++; // visit counting by integer array
		int result = order[vertex];

		for (int now : arraylist.get(vertex)) {
			if (now == parent) { // the path already passed has to be excluded.
				continue;
			}

			if (order[now] == 0) { // If a child vertex is not visited.
				int low = dfs(now, vertex, arraylist); // The 'low' is the visit number visited first among child
														// vertexes (1)

				if (low > order[vertex]) { // If the 'low' is larger than the 'order[vertex]', the 'node' is an
											// articulation bridge.
					if (now > vertex) { // problem condition: A > B(The lower is the first.)
						ans.add(new Node(vertex, now));
					} else {
						ans.add(new Node(now, vertex));
					}
				}
				result = Math.min(result, low); // the value visited first among child vertexes (2)

			} else { // If the child node is already visited.
				result = Math.min(result, order[now]);
			}
		}

		return result;
	}
}

// reference: https://steady-coding.tistory.com/256