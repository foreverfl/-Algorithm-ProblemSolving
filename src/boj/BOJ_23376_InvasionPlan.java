package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_23376_InvasionPlan {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		long ans = 0;
		if (y == 0) {
			ans = calcInCaseOfZero(x);
		} else {
			long base = calcInCaseOfZero((x + y) - 1);
			ans = base + y;
		}

		System.out.println(ans);

	}

	private static long calcInCaseOfZero(int num) {
		long res = 0;
		int diff = 0;
		if (num >= 0) {
			res = 1; // 초항
			diff = 0; // 첫 계차
			for (int i = 0; i < num; i++) {
				diff += 6;
				res += diff;
			}
		} else {
			res = 4; // 초항
			diff = 3; // 첫 계차
			for (int i = 0; i < Math.abs(num) - 1; i++) {
				diff += 6;
				res += diff;
			}
		}

		return res;
	}

}
