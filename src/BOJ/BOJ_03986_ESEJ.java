package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_03986_ESEJ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int ans = 0;
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < str.length(); i++) {

				char tmp = str.charAt(i);

				boolean flag = false;
				while (!stack.empty() && stack.peek() == tmp) {
					stack.pop();
					flag = true;
				}

				if (!flag) {
					stack.push(tmp);
				}
			}

			if (stack.empty())
				ans++;
		}

		System.out.println(ans);
	}

}
