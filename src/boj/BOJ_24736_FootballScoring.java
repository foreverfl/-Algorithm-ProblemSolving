package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24736_FootballScoring {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int repeat = 2;
		while (repeat-- > 0) {
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int F = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			int result = calculateScore(T, F, S, P, C);
			sb.append(result).append(" ");
		}
		
		System.out.println(sb.toString());

	}

	private static int calculateScore(int a, int b, int c, int d, int e) {
		return a * 6 + b * 3 + c * 2 + d + e * 2;
	}

}
