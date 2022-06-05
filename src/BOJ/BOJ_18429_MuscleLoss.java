package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429_MuscleLoss {

	static int[] arr;
	static int[] order;
	static boolean[] visited;
	static int N, K;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		order = new int[N + 1];
		visited = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		backTracking(1);

		System.out.println(ans);
	}

	public static void backTracking(int depth) {
		if (depth == N + 1) {
			int muscle = 500;
			boolean flag = true;
			for (int i = 1; i <= N; i++) {
				muscle = muscle - K;
				muscle += arr[order[i]];

				if (muscle < 500) {
					flag = false;
					break;
				}
			}

			if (flag)
				ans++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				order[depth] = i;
				backTracking(depth + 1);
				visited[i] = false;
			}
		}
	}

}
