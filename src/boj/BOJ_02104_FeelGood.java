package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_02104_FeelGood {

	static class Pair {
		int height;
		long width;

		Pair(int height, long width) {
			this.height = height;
			this.width = width;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Stack<Pair> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());

		long width;
		long ans = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			int height = Integer.parseInt(st.nextToken());
			width = 0;
			while (!stack.empty() && height < stack.peek().height) {
				width += stack.peek().width;
				ans = Math.max(ans, width * stack.peek().height);
				stack.pop();
			}
			width += height;
			stack.push(new Pair(height, width));
		}

		width = 0;

		while (!stack.empty()) {
			width += stack.peek().width;
			ans = Math.max(ans, width * stack.peek().height);
			stack.pop();
		}

		System.out.println(ans);

	}

}

// reference: https://t-anb.tistory.com/15
