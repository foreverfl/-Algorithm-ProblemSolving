package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solving_BOJ_14540_RailwayStation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}

			while (true) {
				String trains = br.readLine();
				if (trains.equals("0"))
					break;

				Stack<Integer> stack = new Stack<>();
				st = new StringTokenizer(trains);

				for (int i = 0; i < N; i++) {

					int now = Integer.parseInt(st.nextToken());

					if (!stack.isEmpty() && stack.peek() < now) {
						stack.pop();
					}

					stack.push(now);

				}

				while (true) {
					if (stack.size() == 1) {
						stack.pop();
						break;
					}

					int tmp = stack.pop();

					if (tmp < stack.peek())
						stack.pop();
				}

				if (stack.isEmpty()) {
					sb.append("Yes").append('\n');
				} else {
					sb.append("No").append('\n');
				}

			}

			sb.append('\n');
		}

		System.out.print(sb.toString());

	}

}
