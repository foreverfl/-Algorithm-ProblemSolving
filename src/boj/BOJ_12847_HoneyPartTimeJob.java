package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12847_HoneyPartTimeJob {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long sum = 0;
		long[] sums = new long[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			sum += Integer.parseInt(st.nextToken());
			sums[i] = sum;
		}

		long ans = Long.MIN_VALUE;
		for (int i = m; i <= n; i++) {
			long tmp = sums[i] - sums[i - m];
			ans = Math.max(tmp, ans);
		}

		System.out.println(ans);

	}

}
