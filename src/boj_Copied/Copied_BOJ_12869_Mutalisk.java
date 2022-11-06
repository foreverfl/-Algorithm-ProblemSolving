package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_12869_Mutalisk {
	private static int[][] deltas = { { -9, -3, -1 }, { -9, -1, -3 }, { -3, -9, -1 }, { -3, -1, -9 }, { -1, -9, -3 },
			{ -1, -3, -9 } };
	private static int[][][] dp;
	private static int[] scv = new int[3];
	private static int min;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[61][61][61];
		min = Integer.MAX_VALUE;

		dfs(scv, 0);

		System.out.println(min);

	}

	private static void dfs(int[] scv, int cnt) {

		int s1 = scv[0];
		int s2 = scv[1];
		int s3 = scv[2];

		// 공격 횟수 최솟값 보다 현재 공격 횟수가 같거나 클 경우 중단
		if (min <= cnt)
			return;

		// 이미 방문했는데 기존 공격 횟수가 더 작을 경우 중단
		if (dp[s1][s2][s3] != 0 && dp[s1][s2][s3] <= cnt)
			return;

		dp[s1][s2][s3] = cnt;

		// 모든 scv가 죽을 경우 최솟값 갱신 및 중단
		if (s1 == 0 && s2 == 0 && s3 == 0) {
			min = Math.min(min, cnt);
			return;
		}

		// 6가지 공격 패턴으로 현재 scv를 공격한 후 넘김
		// Math.max()를 통해 scv의 체력을 0 이하로 떨어지지 않게함
		for (int i = 0; i < 6; i++) {
			dfs(new int[] { Math.max(s1 + deltas[i][0], 0), Math.max(s2 + deltas[i][1], 0),
					Math.max(s3 + deltas[i][2], 0) }, cnt + 1);
		}
	}
}

// reference: https://velog.io/@gandi0330/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Java-%EB%B0%B1%EC%A4%80-%EB%AE%A4%ED%83%88%EB%A6%AC%EC%8A%A4%ED%81%AC-12869
