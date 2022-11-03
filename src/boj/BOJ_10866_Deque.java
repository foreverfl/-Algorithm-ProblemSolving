package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_10866_Deque {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Deque<Integer> deque = new ArrayDeque<>();

		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			String str = br.readLine();
			st = new StringTokenizer(str);

			String op = st.nextToken();

			if (op.equals("push_front")) {
				deque.offerFirst(Integer.parseInt(st.nextToken()));
			} else if (op.equals("push_back")) {
				deque.offerLast(Integer.parseInt(st.nextToken()));
			} else if (op.equals("pop_front")) {
				if (deque.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(deque.pollFirst()).append('\n');
			} else if (op.equals("pop_back")) {
				if (deque.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(deque.pollLast()).append('\n');
			} else if (op.equals("size")) {
				sb.append(deque.size()).append('\n');
			} else if (op.equals("empty")) {
				if (deque.isEmpty())
					sb.append(1).append('\n');
				else
					sb.append(0).append('\n');
			} else if (op.equals("front")) {
				if (deque.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(deque.peekFirst()).append('\n');
			} else if (op.equals("back")) {
				if (deque.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(deque.peekLast()).append('\n');
			}

		}

		System.out.println(sb.toString());

	}

}
