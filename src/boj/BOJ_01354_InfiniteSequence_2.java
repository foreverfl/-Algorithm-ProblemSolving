package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_01354_InfiniteSequence_2 {

	static long N, P, Q, X, Y;
	static HashMap<Long, Long> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		X = Long.parseLong(st.nextToken());
		Y = Long.parseLong(st.nextToken());

		System.out.print(dp(N));

	}

	public static long dp(long N) {
		if (N <= 0)
			return 1;
		
		if (map.containsKey(N))
			return map.get(N);

		map.put(N, dp(N / P - X) + dp(N / Q - Y));

		return map.get(N);
	}

}

// reference: https://sdev.tistory.com/570
