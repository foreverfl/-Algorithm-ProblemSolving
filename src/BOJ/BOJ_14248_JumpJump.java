package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14248_JumpJump {

	static int[] map;
	static boolean[] visited;
	static boolean[] check;
	static int n;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new int[n + 1];
		visited = new boolean[n + 1];
		check = new boolean[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		int s = Integer.parseInt(br.readLine());

		dfs(s);

		for (int i = 1; i <= n; i++) {
			if (check[i])
				ans++;
		}

		System.out.println(ans);

	}

	public static void dfs(int num) {

		check[num] = true;
		visited[num] = true;
		int distance = map[num];

		int right = num + distance;
		int left = num - distance;

		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				if (right <= 0 || right > n)
					continue;
				if (visited[right])
					continue;

				dfs(right);
			} else {
				if (left <= 0 || left > n)
					continue;

				if (visited[left])
					continue;

				dfs(left);

			}
		}

	}

}
