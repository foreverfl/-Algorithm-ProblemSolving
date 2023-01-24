package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solving_BOJ_14843_InfoGoatYounghoon {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		BigDecimal total = BigDecimal.ZERO;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			BigDecimal S = new BigDecimal(st.nextToken());
			BigDecimal A = new BigDecimal(st.nextToken());
			BigDecimal T = new BigDecimal(st.nextToken());
			BigDecimal M = new BigDecimal(st.nextToken());
			BigDecimal res = calc(S, A, T, M);
			total = total.add(res);
		}

		int P = Integer.parseInt(br.readLine());
		BigDecimal[] arr = new BigDecimal[P + 1];
		for (int i = 0; i < P; i++) {
			arr[i] = new BigDecimal(br.readLine());
		}
		arr[P] = total;

		Arrays.sort(arr, Collections.reverseOrder());

		int grade = 0;
		for (int i = 0; i < P + 1; i++) {
			if (arr[i] == total) {
				grade = i + 1;
				break;
			}
		}

		double percent = (double) (grade * 100) / (P + 1);
		double ans = total.doubleValue();
		String ans_string = String.format("%.2f", ans);

		if (percent <= 15) {
			System.out.println("The total score of \"The God\" is " + ans_string + ".");
		} else {
			System.out.println("The total score of Younghoon is " + ans_string + ".");
		}

	}

	private static BigDecimal calc(BigDecimal S, BigDecimal A, BigDecimal T, BigDecimal M) {
		BigDecimal ans = S
				.multiply(BigDecimal.ONE.add(BigDecimal.ONE.divide(A, MathContext.DECIMAL128))
						.multiply(BigDecimal.ONE.add(M.divide(T, MathContext.DECIMAL128))))
				.divide(new BigDecimal("4"), MathContext.DECIMAL128);

		return ans;
	}

}
