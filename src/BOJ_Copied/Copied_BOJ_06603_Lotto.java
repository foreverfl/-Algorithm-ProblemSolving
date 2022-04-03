package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_06603_Lotto {

	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if (k == 0)
				break;
			else {
				arr = new int[k];
				visited = new boolean[k];
				for (int i = 0; i < k; i++) {
					arr[i] = Integer.parseInt(st.nextToken());
				}
				backtracking(0, 0);
			}
			sb.append('\n');
		}

		System.out.println(sb.toString());

	}

	private static void backtracking(int depth, int idx) {
		if (depth == 6) {
			for (int i = 0; i < arr.length; i++) {
				if (visited[i]) {
					sb.append(arr[i] + " ");
				}
			}
			sb.append('\n');
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				backtracking(depth + 1, i);
				visited[i] = false;
			}
		}
	}
}

// reference: https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-6603-%EB%A1%9C%EB%98%90-java
