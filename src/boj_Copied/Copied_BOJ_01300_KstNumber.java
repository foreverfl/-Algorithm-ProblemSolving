package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_01300_KstNumber {

	static int N, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		long lo = 1;
		long hi = k;

		// lower-bound
		while (lo < hi) {

			long mid = (lo + hi) / 2;
			long count = 0;

			for (int i = 1; i <= N; i++) {
				count += Math.min(mid / i, N); // The 'count' is the sum of accumulated numbers.
			}

			if (k <= count) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		System.out.println(lo);
	}
}

// reference: https://st-lab.tistory.com/281
