package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Copied_BOJ_01325_EffectiveHacking {

	static class Computer {
		int idx;
		ArrayList<Computer> adj;

		public Computer(int idx) {
			this.idx = idx;
			this.adj = new ArrayList<>();
		}
	}

	static Computer[] comps;
	static int n;
	static int m;
	static boolean[] visited;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		comps = new Computer[n + 1];
		for (int i = 1; i <= n; i++) {
			comps[i] = new Computer(i);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// A->B 신뢰이면 B를 해킹하면 A도 해킹할 수 있음.
			// B의 인접리스트에 A를 저장
			comps[b].adj.add(comps[a]);
		}

		answer = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			visited[i] = true;
			dfs(i, i);
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, answer[i]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (max == answer[i]) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int start, int now) {

		for (Computer c : comps[now].adj) {
			if (!visited[c.idx]) {
				visited[c.idx] = true;
				dfs(start, c.idx);
				answer[start]++;
			}
		}

	}
}

// reference: https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-1325-%ED%9A%A8%EC%9C%A8%EC%A0%81%EC%9D%B8-%ED%95%B4%ED%82%B9-JAVA