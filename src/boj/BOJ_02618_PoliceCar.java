package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_02618_PoliceCar {

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static List<Pair> pathA = new ArrayList<>();
	static List<Pair> pathB = new ArrayList<>();
	static int[][] dp = new int[1001][1001];
	static int N, W;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		W = Integer.parseInt(br.readLine());

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		pathA.add(new Pair(1, 1));
		pathB.add(new Pair(N, N));

		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pathA.add(new Pair(x, y));
			pathB.add(new Pair(x, y));
		}

		sb.append(getMaxDistance(0, 0)).append('\n');
		reconstruct(0, 0);

		System.out.print(sb.toString());

	}

	public static int getMaxDistance(int A, int B) {
		if (A == W || B == W) // all cleared
			return 0;

		int res = dp[A][B];

		if (res != -1)
			return res;

		res = 987654321;

		// the next case
		int nxt = Math.max(A, B) + 1;

		// distance when A resolved the next case
		int distA = Math.abs(pathA.get(nxt).x - pathA.get(A).x) + Math.abs(pathA.get(nxt).y - pathA.get(A).y);

		// distance when B resolved the next case
		int distB = Math.abs(pathB.get(nxt).x - pathB.get(B).x) + Math.abs(pathB.get(nxt).y - pathB.get(B).y);

		int ret1 = getMaxDistance(nxt, B) + distA;
		int ret2 = getMaxDistance(A, nxt) + distB;

		res = Math.min(ret1, ret2);
		dp[A][B] = res;

		return res;
	}

	public static void reconstruct(int A, int B) {
		if (A == W || B == W)
			return;

		int nxt = Math.max(A, B) + 1;

		int distA = Math.abs(pathA.get(nxt).x - pathA.get(A).x) + Math.abs(pathA.get(nxt).y - pathA.get(A).y);

		int distB = Math.abs(pathB.get(nxt).x - pathB.get(B).x) + Math.abs(pathB.get(nxt).y - pathB.get(B).y);

		int res1 = getMaxDistance(nxt, B) + distA;
		int res2 = getMaxDistance(A, nxt) + distB;

		if (res1 > res2) {
			sb.append(2).append('\n');
			reconstruct(A, nxt);
		} else {
			sb.append(1).append('\n');
			reconstruct(nxt, B);
		}

	}

}

// reference: https://injae-kim.github.io/problem_solving/2020/03/11/baekjoon-2618.html
