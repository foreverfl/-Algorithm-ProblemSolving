package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_24445_AlgorithmClassBFS2 {

	private static int N, M, R;
	private static boolean[] visited;
	private static List<Integer>[] list;
	private static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		list = new ArrayList[N + 1];
		ans = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i], Collections.reverseOrder());
		}

		bfs(R);

		for (int i = 1; i <= N; i++) {
			System.out.println(ans[i]);
		}

	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.add(start);

		int i = 1;
		while (queue.size() != 0) {
			start = queue.poll();
			ans[start] = i++;

			Iterator<Integer> iterator = list[start].listIterator();
			while (iterator.hasNext()) {
				int w = iterator.next();
				if (!visited[w]) {
					visited[w] = true;
					queue.add(w);
				}
			}
		}
	}

}
