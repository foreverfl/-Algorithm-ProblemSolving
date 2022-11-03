package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11497_LogJumping {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}

			Deque<Integer> deque = new ArrayDeque<>();
			while (!pq.isEmpty()) {
				if (!pq.isEmpty()) {
					deque.addFirst(pq.poll());

				}

				if (!pq.isEmpty()) {
					deque.addLast(pq.poll());

				}
			}

			int a = 0, b = 0;
			int max = Integer.MIN_VALUE;
			while (!deque.isEmpty()) {

				a = deque.pollFirst();
				if (!deque.isEmpty())
					b = deque.peekFirst();
				
				int tmp = Math.abs(a - b);
				if (tmp >= max) {
					max = tmp;
				}
			}
			sb.append(max).append('\n');
		}

		System.out.println(sb.toString());
	}

}
