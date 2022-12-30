package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solving_BOJ_12389_SafetyInNumbers_Large {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String[] y = new String[N];
			int[] j = new int[N];
			int x = 0;

			for (int k = 0; k < N; k++) {
				j[k] = Integer.parseInt(st.nextToken());
				x += j[k];
			}
			
			for (int k = 0; k < N; k++) {
				double res = (double) j[N - (k + 1)] / x * 100;
				y[k] = String.format("%.5f", res);
			}

			sb.append("Case #" + i + ": ");
			for (int k = 0; k < y.length; k++) {
				sb.append(y[k] + " ");
			}
			sb.append('\n');
		}

		System.out.println(sb.toString());

	}

}
