package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Copied_BOJ_05430_AC {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		ArrayDeque<Integer> deque;
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {

			String command = br.readLine(); // The 'commend' means the 'P'
			int n = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine(), "[],");

			deque = new ArrayDeque<Integer>();

			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}

			AC(command, deque);
		}

		System.out.println(sb);

	}

	public static void AC(String command, ArrayDeque<Integer> deque) {

		boolean isRight = true;

		for (char cmd : command.toCharArray()) {

			if (cmd == 'R') {
				isRight = !isRight; // It changes direction.
				continue;
			}

			// in case of the 'D'
			if (isRight) {
				if (deque.pollFirst() == null) { // if there are no returned elements.
					sb.append("error\n");
					return; // exit
				}
			} else {
				if (deque.pollLast() == null) {
					sb.append("error\n");
					return;
				}
			}
		}

		makePrintString(deque, isRight);

	}

	public static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {

		sb.append('[');

		if (deque.size() > 0) {

			if (isRight) { 

				sb.append(deque.pollFirst());

				
				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			} else { // reversed
				sb.append(deque.pollLast());
				
				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}
		}

		sb.append(']').append('\n');
	}
}

// reference: https://st-lab.tistory.com/221