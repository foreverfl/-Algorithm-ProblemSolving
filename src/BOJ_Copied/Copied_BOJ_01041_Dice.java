package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01041_Dice {
	private static long N;
	private static long one, two, three;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int[] dice = new int[6];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 6; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}

		long minAF = Math.min(dice[0], dice[5]);
		long minBE = Math.min(dice[1], dice[4]);
		long minCD = Math.min(dice[2], dice[3]);

		one = Math.min(minAF, Math.min(minBE, minCD));
		two = Math.min(minAF + minBE, Math.min(minAF + minCD, minBE + minCD));
		three = minAF + minBE + minCD;

		long sum = minSum(dice);

		System.out.println(String.valueOf(sum));
	}

	private static long minSum(int[] dice) {
		long sum = 0;
		if (N == 1) {
			long max = Integer.MIN_VALUE;
			for (int i = 0; i < 6; i++) {
				max = Math.max(max, dice[i]);
				sum += dice[i];
			}
			return sum - max;
		}

		long oneSide = 4 * (N - 1) * (N - 2) + (N - 2) * (N - 2);
		long secondSide = 4 * (N - 1) + 4 * (N - 2);
		long thirdSide = 4;

		sum += one * oneSide + two * secondSide + three * thirdSide;
		return sum;
	}
}

// reference: https://velog.io/@zayson/BOJ-1041%EB%B2%88-%EC%A3%BC%EC%82%AC%EC%9C%84