package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15971_TwoRobots {

	static class Node {
		int num;
		int weight;
		int total;
		int longest;

		Node(int num, int weight, int total, int longest) {
			this.num = num;
			this.weight = weight;
			this.total = total;
			this.longest = longest;
		}

	}

	static List<List<Node>> list;
	static boolean[] visited = new boolean[100001];
	static int N, r1, r2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());

		// init
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			List<Node> tmp = new ArrayList<>();
			list.add(tmp);
		}

		int repeat = N - 1;
		while (repeat-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list.get(x).add(new Node(y, w, 0, 0));
			list.get(y).add(new Node(x, w, 0, 0));
		}

		bfs(r1);
	}

	public static void bfs(int num) {

		Queue<Node> queue = new LinkedList<>();

		queue.offer(new Node(num, 0, 0, 0));
		visited[num] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			if (now.num == r2) {
				int ans = now.total - now.longest;
				System.out.print(ans);
				return;
			}

			for (Node i : list.get(now.num)) {

				if (isRange(i.num) && !visited[i.num]) {
					queue.offer(new Node(i.num, i.weight, now.total + i.weight, Math.max(now.longest, i.weight)));
					visited[i.num] = true;
				}
			}

		}

	}

	public static boolean isRange(int num) {
		if (num >= 1 && num <= 100000)
			return true;

		return false;
	}

}
