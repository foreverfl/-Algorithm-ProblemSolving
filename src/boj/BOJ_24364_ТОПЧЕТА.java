package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24364_ТОПЧЕТА {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long max = Long.MIN_VALUE;
		long min = Long.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			long now = Long.parseLong(st.nextToken());
			max = Math.max(max, now);
			min = Math.min(min, now);
		}

		long ans = Math.abs(max - min);
		System.out.println(ans);

	}

}
