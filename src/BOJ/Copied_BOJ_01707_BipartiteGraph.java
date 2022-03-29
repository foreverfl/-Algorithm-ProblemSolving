package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_01707_BipartiteGraph {

	static int v, e;
	static ArrayList<Integer>[] arraylist;
	static int visited[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			visited = new int[v + 1];
			arraylist = new ArrayList[v + 1];

			for (int j = 0; j <= v; j++)
				arraylist[j] = new ArrayList<Integer>();

			for (int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				arraylist[a].add(b);
				arraylist[b].add(a);
			}
			grouping();
		}
		
		System.out.println(sb.toString());
	}

	public static void grouping() {
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= v; i++) {
			if (visited[i] == 0) {
				queue.add(i);
				visited[i] = 1;
			}

			while (!queue.isEmpty()) {
				int now = queue.poll();

				for (int j = 0; j < arraylist[now].size(); j++) {
					if (visited[arraylist[now].get(j)] == 0) {
						queue.add(arraylist[now].get(j));
					}

					if (visited[arraylist[now].get(j)] == visited[now]) {
						sb.append("NO").append('\n');
						return;
					}

					if (visited[now] == 1 && visited[arraylist[now].get(j)] == 0)
						visited[arraylist[now].get(j)] = 2;
					else if (visited[now] == 2 && visited[arraylist[now].get(j)] == 0)
						visited[arraylist[now].get(j)] = 1;
				}
			}
		}

		sb.append("YES").append('\n');
	}

}

// reference: https://jellyinghead.tistory.com/14