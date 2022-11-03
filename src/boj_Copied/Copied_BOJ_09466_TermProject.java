package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_09466_TermProject {

	static int[] arr;
	static boolean[] visited, finished;
	static int n, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			n = Integer.parseInt(br.readLine());
			cnt = 0;
			arr = new int[n + 1];
			visited = new boolean[n + 1];
			finished = new boolean[n + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {

				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= n; i++) {
				dfs(i);
			}

			sb.append(n - cnt).append('\n');

		}

		System.out.println(sb.toString());

	}

	private static void dfs(int now) {
		if (visited[now])
			return;

		visited[now] = true;
		int next = arr[now];

		if (!visited[next])
			dfs(next);

		else {
			if (!finished[next]) {
				cnt++;
				for (int i = next; i != now; i = arr[i])
					cnt++;
			}
		}

		finished[now] = true;
	}

}

// reference: https://bcp0109.tistory.com/32