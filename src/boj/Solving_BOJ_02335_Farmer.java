package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solving_BOJ_02335_Farmer {

	private static class Tree {
		int used;
		int remains;

		public Tree() {

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int Q = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Integer[] fields = new Integer[N + 1];
		Integer[] strips = new Integer[K + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			fields[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= K; i++) {
			strips[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(fields, Collections.reverseOrder());
		Arrays.sort(strips, Collections.reverseOrder());

		Tree[][] dp = new Tree[K + 1][N + 1];

		int ans = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			Tree tree = new Tree();
			tree.used = strips[i];
			tree.remains = Q - strips[i];
			dp[0][i] = tree;

		}
	}

}
