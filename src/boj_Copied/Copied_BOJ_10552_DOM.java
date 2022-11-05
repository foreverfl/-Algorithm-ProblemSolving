package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_10552_DOM {

	private static int N, M, P;
	private static int[] likes;
	private static boolean[] visited;
	private static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		likes = new int[M + 1];
		visited = new boolean[M + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int like = Integer.parseInt(st.nextToken());
			int hate = Integer.parseInt(st.nextToken());
			if (likes[hate] == 0)
				likes[hate] = like;
		}

		dfs(P);

		System.out.println(res);
	}

	private static void dfs(int ch) {
		if (visited[ch])
			res = -1;
		else if (likes[ch] != 0) {
			res++;
			visited[ch] = true;
			dfs(likes[ch]);
		}
	}
}

// reference: https://velog.io/@cchloe2311/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-10552.-DOM
