package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Copied_BOJ_03015_PATRIK {

	static class Pair {

		int height;
		int cnt;

		Pair(int height, int cnt) {
			this.height = height;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Pair> stack = new Stack<>();
		long cnt = 0;

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(br.readLine());
			Pair now = new Pair(height, 1);

			while (!stack.empty() && stack.peek().height <= height) {
				Pair tmp = stack.pop(); // Can be seen because they are short.
				cnt += tmp.cnt;
				if (tmp.height == height)
					now.cnt += tmp.cnt;
			}

			if (!stack.empty()) // There is one who can be seen and is taller.
				cnt++;

			stack.push(now);
		}

		System.out.println(cnt);
	}

}

// reference: https://www.acmicpc.net/problem/3015