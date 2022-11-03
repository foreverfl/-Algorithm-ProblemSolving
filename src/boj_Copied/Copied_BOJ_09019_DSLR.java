package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_09019_DSLR {

	static String[] command; // the array for answer
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {

			visited = new boolean[10000];
			command = new String[10000];
			Arrays.fill(command, "");

			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			String result = bfs(A, B);
			sb.append(result).append('\n');
		}

		System.out.println(sb.toString());
	}

	private static String bfs(int start, int target) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.add(start);

		while (!queue.isEmpty() && !visited[target]) {
			int now = queue.poll();
			int D = (2 * now) % 10000;
			int S = (now == 0) ? 9999 : now - 1;
			int L = (now % 1000) * 10 + now / 1000;
			int R = (now % 10) * 1000 + now / 10;

			if (!visited[D]) {
				queue.add(D);
				visited[D] = true;
				command[D] = command[now] + "D";
			}

			if (!visited[S]) {
				queue.add(S);
				visited[S] = true;
				command[S] = command[now] + "S";
			}
			if (!visited[L]) {
				queue.add(L);
				visited[L] = true;
				command[L] = command[now] + "L";
			}
			if (!visited[R]) {
				queue.add(R);
				visited[R] = true;
				command[R] = command[now] + "R";
			}
		}

		return command[target];
	}

}

// reference: https://log-laboratory.tistory.com/134
