package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_01935_Postfix_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String str = br.readLine();

		double[] number = new double[26];
		for (int i = 0; i < N; i++) {
			float input = (Float.parseFloat(br.readLine()));
			number[i] = input;
		}

		Stack<Double> stack = new Stack<>();
		double ans = Integer.MIN_VALUE;
		for (int i = 0; i < str.length(); i++) {

			char tmp = str.charAt(i);

			if (tmp >= 'A' && tmp <= 'Z') {
				stack.push(number[tmp - 'A']);
			} else {

				double A = stack.pop();
				double B = stack.pop();

				if (tmp == '+') {

					ans = B + A;

				} else if (tmp == '-') {

					ans = B - A;

				} else if (tmp == '/') {

					ans = B / A;

				} else if (tmp == '*') {

					ans = B * A;

				}

				stack.push(ans);
			}
		}

		System.out.printf("%.2f", stack.pop());

	}

}
