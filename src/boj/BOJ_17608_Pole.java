package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17608_Pole {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			stack.add(Integer.parseInt(br.readLine()));
		}

		int tallest = stack.peek();
		int ans = 1;
		while (!stack.isEmpty()) {
			if (tallest < stack.peek()) {
				tallest = stack.peek();
				stack.pop();
				ans++;
			} else {
				stack.pop();
			}
		}

		System.out.println(ans);

	}

}
