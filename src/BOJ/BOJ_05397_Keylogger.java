package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_05397_Keylogger {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			Stack<Character> left = new Stack<>();
			Stack<Character> right = new Stack<>();

			String str = br.readLine();

			for (int i = 0; i < str.length(); i++) {
				char tmp = str.charAt(i);

				if (tmp == '<') {

					if (left.isEmpty())
						continue;
					else {
						char tmp_01 = left.pop();
						right.push(tmp_01);
					}

				} else if (tmp == '>') {

					if (right.isEmpty())
						continue;
					else {
						char tmp_01 = right.pop();
						left.push(tmp_01);
					}

				} else if (tmp == '-') {

					if (left.empty())
						continue;
					else
						left.pop();

				} else {

					left.add(tmp);

				}
			}

			while (!left.empty()) {
				right.push(left.pop());
			}

			while (!right.empty()) {
				sb.append(right.pop());
			}
			sb.append('\n');
		}

		System.out.println(sb.toString());
	}

}
