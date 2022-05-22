package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_12605_ReverseWords_Small {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {

			Stack<String> stack = new Stack<>();

			sb.append("Case #" + (i + 1) + ": ");

			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens())
				stack.add(st.nextToken());

			while (!stack.isEmpty())
				sb.append(stack.pop() + " ");

			sb.append('\n');
		}

		System.out.println(sb.toString());

	}

}
