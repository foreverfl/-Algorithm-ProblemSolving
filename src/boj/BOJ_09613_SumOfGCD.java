package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_09613_SumOfGCD {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			long sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					int tmp = gcd(arr[i], arr[j]);
					sum += tmp;
				}
			}
			sb.append(sum).append('\n');
		}

		System.out.println(sb.toString());
	}

	private static int gcd(int a, int b) {

		while (b != 0) {
			int r = a % b; // r = remains

			// GCD(a, b) = GCD(b, r)
			a = b;
			b = r;
		}
		return a;
	}

}
