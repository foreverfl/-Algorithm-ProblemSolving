package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_01759_MakingPassword {

	static int L, C;
	static char[] arr;
	static boolean[] visited;

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

	}

	private static void backtracking(int depth, int idx) {
		if (depth == L) {
			int v = 0;
			int cc = 0;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < C; i++) {
				if (visited[i]) {
					sb.append(arr[i]);
					if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
						v++;
					} else {
						cc++;
					}
				}
			}
			if (v >= 1 && cc >= 2)
				System.out.println(sb.toString());
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

// reference: https://velog.io/@ssojin/%EB%B0%B1%EC%A4%80-1759-%EC%95%94%ED%98%B8%EB%A7%8C%EB%93%A4%EA%B8%B0-Java