package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solving_BOJ_10913_Uniting {

	private static final int MOD = 1000000007;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 1;

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			pq.add(arr[i]);
		}

		long min = 1;
		while (true) {
			if (pq.size() == 1)
				break;

			int a = pq.poll();
			int b = pq.poll();
			int tmp = a * b;
			min *= tmp;
			pq.offer(tmp);

		}

		for (int i = 1; i <= N; i++) {
			dp[i] = i * dp[i - 1] % MOD;
		}

		System.out.println(min);
		System.out.println(dp[N] % MOD);

	}

}
