package boj_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Copied_BOJ_13023_ABCDE {

	private static int N, M;
	private static ArrayList<Integer>[] list;
	private static int flag = 0;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}

		for (int i = 0; i < N; i++) {
			if (flag == 0)
				dfs(i, 1);
		}

		System.out.println(flag);
	}

	public static void dfs(int idx, int depth) {
		if (depth == 5) {
			flag = 1;
			return;
		}

		visited[idx] = true;
		
		for (int nxt : list[idx]) {
			if (!visited[nxt]) {
				dfs(nxt, depth + 1);
			}
		}
		
		visited[idx] = false;

	}
}

// reference: https://minhamina.tistory.com/50