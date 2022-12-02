package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solving_BOJ_05605_Problem4 {

	private static class Node {
		int num;
		int before;
		int len;

		public Node(int num, int before, int len) {
			this.num = num;
			this.len = len;
			this.before = before;
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", before=" + before + ", len=" + len + "]";
		}

	}

	private static List<Node>[] list;
	private static int visited[];
	private static int ans = Integer.MIN_VALUE;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, 0, 0));
			list[b].add(new Node(a, 0, 0));
		}

//		for (int i = 1; i <= n; i++) {
//			visited = new int[n + 1];
//			bfs(i);
//		}
		
		visited = new int[n + 1];
		bfs(2);

		System.out.println(ans);
	}

	private static void bfs(int num) {

		int cnt = Integer.MIN_VALUE;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(num, 0, 0));
		visited[num] = 1;

		while (!queue.isEmpty()) {
			Node now = queue.poll();
			cnt = Math.max(cnt, now.len + 1);

			for (int i = 0; i < list[now.num].size(); i++) {
				int nxt = list[now.num].get(i).num;
				if (visited[nxt] == 2)
					continue;

				if (now.before == nxt)
					continue;

				visited[nxt] += 1;
				queue.add(new Node(nxt, now.num, now.len + 1));
			}
		}

		ans = Math.max(ans, cnt);
	}

}
