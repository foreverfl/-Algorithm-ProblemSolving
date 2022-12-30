package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11441_FindingSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] sums = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += Integer.parseInt(st.nextToken());
			sums[i] = sum;
		}

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			sb.append(sums[j] - sums[i - 1]).append('\n');
		}
		System.out.println(sb.toString());
	}

}
