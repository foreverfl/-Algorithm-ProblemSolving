package programmers_Copied;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Copied_Programmers_132266_TroopsWhoComesBack {

	public static void main(String[] args) {

		// int[] arr = solution(3, new int[][] { { 1, 2 }, { 2, 3 } }, new int[] { 2, 3
		// }, 1);
		// System.out.println(Arrays.toString(arr));

		int[] arr = solution(5, new int[][] { { 1, 2 }, { 1, 4 }, { 2, 4 }, { 2, 5 }, { 4, 5 } }, new int[] { 1, 3, 5 },
				5);
		System.out.println(Arrays.toString(arr));

	}

	private static List<Integer>[] list;
	private static int[] dist;
	private static final int MAX = 100000000;

	@SuppressWarnings("unchecked")
	public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
		list = new ArrayList[n + 1];
		dist = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < roads.length; i++) {
			int from = roads[i][0];
			int to = roads[i][1];
			list[from].add(to);
			list[to].add(from);
		}

		Arrays.fill(dist, MAX);
		dijkstra(destination);

		int[] ans = new int[sources.length];
		for (int i = 0; i < sources.length; i++) {
			ans[i] = (dist[sources[i]] < MAX) ? dist[sources[i]] : -1;
		}
		return ans;
	}

	private static void dijkstra(int dest) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(dest);
		dist[dest] = 0;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 0; i < list[now].size(); i++) {
				int nxt = list[now].get(i);
				if (dist[nxt] > dist[now] + 1) {
					dist[nxt] = dist[now] + 1;
					queue.add(nxt);
				}
			}
		}
	}

}
