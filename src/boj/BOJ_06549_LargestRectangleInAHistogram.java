package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_06549_LargestRectangleInAHistogram {
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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String str = br.readLine();
		while (!str.equals("0")) {

			Stack<Pair> stack = new Stack<>();
			st = new StringTokenizer(str);
			int N = Integer.parseInt(st.nextToken());

			long width;
			long ans = 0;

			for (int i = 0; i < N; ++i) {
				int height = Integer.parseInt(st.nextToken());
				width = 0;
				while (!stack.empty() && height < stack.peek().height) {
					width += stack.peek().width;
					ans = Math.max(ans, width * stack.peek().height);
					stack.pop();
				}
				width++;
				stack.push(new Pair(height, width));
			}

			width = 0;

			while (!stack.empty()) {
				width += stack.peek().width;
				ans = Math.max(ans, width * stack.peek().height);
				stack.pop();
			}

			sb.append(ans).append('\n');

			str = br.readLine();
		}

		System.out.println(sb.toString());

	}
}
