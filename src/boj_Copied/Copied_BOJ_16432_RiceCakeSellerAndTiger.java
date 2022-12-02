package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_16432_RiceCakeSellerAndTiger {

	private static int N, K;
	private static boolean isPossible;
	private static int arr[][], dp[];
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][10];
		visited = new boolean[N + 1][10];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				arr[i][Integer.parseInt(st.nextToken())] = 1;
			}
		}

		get(0, 0);

		if (isPossible) {
			for (int i = 0; i < N; i++) {
				sb.append(dp[i]).append("\n");
			}
		} else {
			sb.append(-1);

		}

		System.out.println(sb.toString());
	}

	private static void get(int num, int depth) {
		if (depth == N) {
			isPossible = true;
			return;
		}

		for (int i = 1; i < 10; i++) {
			/// 이전 값과 비교하고 다음 값이 있는지 확인한다.
			if (num == i)
				continue;

			if (arr[depth][i] == 1 && !visited[depth + 1][i]) {
				// 재방문해도 아래쪽 결과는 같으므로 다시 방문하지 않아도 된다.
				visited[depth + 1][i] = true;
				dp[depth] = i;
				get(i, depth + 1);
				
				if (isPossible)
					return;
			}
		}
	}

}

// reference: https://gyuyoungcho.github.io/posts/algorithm/study9/%EB%B0%B1%EC%A4%80_16234_/
