package BOJ_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_06118_HideAndSeek {

	static class Node {
		int index, distance;

		Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer>[] nodes = new ArrayList[N + 1];
		boolean[] visited = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			nodes[v1].add(v2);
			nodes[v2].add(v1);
		}

		int number = 2;
		int maxDistance = -1;
		int count = 1;

		// BFS
		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(1, 0)); // the first value
		visited[1] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			if (maxDistance < now.distance) { // renewing the 'maxDistance'
				maxDistance = now.distance;
				number = now.index;
				count = 1;
			} else if (maxDistance == now.distance) { // counting the 'maxDistance'
				count++;

				if (number > now.index) // renewing the smallest barn
					number = now.index;
			}

			for (int next : nodes[now.index]) {
				if (visited[next])
					continue;

				queue.add(new Node(next, now.distance + 1));
				visited[next] = true;
			}
		}

		sb.append(number + " " + maxDistance + " " + count);
		System.out.println(sb);
	}
}

// reference: https://bcp0109.tistory.com/63