package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_HideAndSeek_3 {

	static int N, K;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new int[200001];

		System.out.println(dfs(N, K));
	}

	private static int dfs(int N, int K) {
		int result = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		visited[N] = 1;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			if (current == K) {
				result = visited[current] - 1;
				break;
			}
			if (isPossible(current * 2)) {
				if (visited[current * 2] == 0) { // not visited
					visited[current * 2] = visited[current];
					queue.add(current * 2);
				}
			}

			if (isPossible(current - 1)) {
				if (visited[current - 1] == 0) { // not visited
					visited[current - 1] = visited[current] + 1;
					queue.add(current - 1);
				}
			}
			
			if (isPossible(current + 1)) {
				if (visited[current + 1] == 0) { // not visited
					visited[current + 1] = visited[current] + 1;
					queue.add(current + 1);
				}

			}

		}

		return result;
	}

	private static boolean isPossible(int a) {
		if (a >= 0 && a <= 100000)
			return true;
		else
			return false;
	}

}
