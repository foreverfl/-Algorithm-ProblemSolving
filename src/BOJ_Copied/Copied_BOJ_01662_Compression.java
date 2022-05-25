package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Copied_BOJ_01662_Compression {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");

		Stack<String> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].equals(")")) {

				stack.push(arr[i]);

			} else {
				int cnt = 0;
				while (!stack.peek().equals("(")) {
					String output = stack.pop();
					if (output.equals("*")) {
						int len = Integer.parseInt(stack.pop());
						cnt += len;
					} else {
						cnt += 1;
					}
				}
				stack.pop(); // '('
				int len = Integer.parseInt(stack.pop());
				cnt *= len;
				stack.push(String.valueOf(cnt));
				stack.push("*"); // The number before '*' is length of answer.
			}
		}

		int ans = 0;
		while (!stack.isEmpty()) {
			if (stack.peek().equals("*")) {
				stack.pop();
				ans += Integer.parseInt(stack.pop());
			} else {
				stack.pop();
				ans += 1;
			}
		}
		System.out.println(ans);
	}

}

// reference: https://codeung.tistory.com/256
