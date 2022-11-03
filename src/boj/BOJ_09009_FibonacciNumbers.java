package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_09009_FibonacciNumbers {

	static List<Integer> fibonacci = new ArrayList<>();
	static List<Integer> print = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int input = Integer.parseInt(br.readLine());
			makeFibonacci(input);
			int tmp = input;
			for (int i = fibonacci.size() - 1; i >= 0; i--) {
				if (fibonacci.get(i) <= tmp) {
					print.add(fibonacci.get(i));
					tmp = tmp - fibonacci.get(i);
				}
			}

			for (int i = print.size() - 1; i >= 0; i--) {
				sb.append(print.get(i) + " ");
			}

			print.clear();
			fibonacci.clear();
			sb.append('\n');
		}

		System.out.println(sb.toString());
	}

	private static void makeFibonacci(int num) {
		int first = 0;
		int second = 1;
		int sum = 1;
		fibonacci.add(1);

		while (true) {
			sum = first + second;
			first = second;
			second = sum;
			fibonacci.add(sum);
			if (sum > num)
				break;
		}
	}

}
