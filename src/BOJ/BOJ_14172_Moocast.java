package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14172_Moocast {

	static class Node {
		int x;
		int y;
		int p;

		Node(int x, int y, int p) {
			this.x = x;
			this.y = y;
			this.p = p;
		}
	}

	static List<Node> graph = new ArrayList<>();
	static boolean[][] visited = new boolean[201][201];
	static int N;
	static int x1, x2, y1, y2;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			graph.add(new Node(x, y, p));
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					visited[i][j] = true;
					continue;
				}

				if ((graph.get(i).p * graph.get(i).p) >= distance(graph.get(i).x, graph.get(i).y, graph.get(j).x,
						graph.get(j).y)) {
					visited[i][j] = true;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, bfs(i));
		}

		System.out.println(ans);
	}

	public static int distance(int x1, int y1, int x2, int y2) {
		int x, y;

		x = Math.abs(x1 - x2);
		x = (int) Math.pow(x, 2);
		y = Math.abs(y1 - y2);
		y = (int) Math.pow(y, 2);

		return x + y;
	}

	public static int bfs(int start) {
		int cnt = 1;
		boolean[] use = new boolean[N];
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(start);
		use[start] = true;

		while (!queue.isEmpty()) {

			int now = queue.poll();

			for (int i = 0; i < N; i++) {
				if (visited[now][i] == true && use[i] == false) {
					use[i] = true;
					queue.offer(i);
					cnt++;
				}
			}

		}

		return cnt;
	}

}

// reference: https://velog.io/@dl-00-e8/BOJ-14172.-Moocast
