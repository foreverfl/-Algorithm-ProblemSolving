package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_12789_SnackGiver {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Stack<Integer> stack = new Stack<>();
		int idx = 1;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (N-- > 0) {
			int input = Integer.parseInt(st.nextToken());

			stack.add(input);

			while (!stack.isEmpty() && stack.peek() == idx) {
				stack.pop();
				idx++;
			}
		}

		if (stack.isEmpty())
			System.out.println("Nice");
		else
			System.out.println("Sad");

	}

}
