package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_01759_MakingPassword {

	static int L, C;
	static char[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[C];
		visited = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(arr);

		backtracking(0, 0);

		System.out.println(sb.toString());
	}

	private static void backtracking(int depth, int idx) {
		if (depth == L) {
			for (int i = 0; i < C; i++) {
				if (visited[i]) {
					sb.append(arr[i]);
				}
			}
			sb.append('\n');
			return;
		}

		for (int i = idx; i < C; i++) {
			if (!visited[i]) {
				visited[i] = true;
				backtracking(depth + 1, i);
				visited[i] = false;
			}
		}
	}

}
