package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_18223_MinjunAndMasanAndGunwoo {

	static List<int[]> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		list = new ArrayList[V + 1];
		for (int i = 1; i < V + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new int[] { to, weight });
			list[to].add(new int[] { from, weight });
		}
		int len1 = solve(1, P, V) + solve(P, V, V);
		int len2 = solve(1, V, V);
		if (len1 == len2) {
			System.out.println("SAVE HIM");
		} else
			System.out.println("GOOD BYE");
	}

	static int solve(int start, int end, int V) {
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
		boolean[] visit = new boolean[V + 1];
		int[] shortest = new int[V + 1];

		for (int i = 0; i < V + 1; i++)
			shortest[i] = Integer.MAX_VALUE;

		shortest[start] = 0;
		pq.add(new int[] { start, 0 });

		while (!pq.isEmpty()) {
			int cur[] = pq.poll();
			int curnode = cur[0];
			if (visit[curnode])
				continue;
			visit[curnode] = true;
			if (curnode == end) {
				return shortest[end];
			}
			for (int[] next : list[cur[0]]) {
				int nextedge = next[1];
				int nextnode = next[0];
				if (!visit[nextnode] && shortest[nextnode] > shortest[curnode] + nextedge) {
					shortest[nextnode] = shortest[curnode] + nextedge;
					pq.add(new int[] { nextnode, nextedge });
				}
			}
		}
		return shortest[end];
	}

}

// reference: https://moons-memo.tistory.com/223
