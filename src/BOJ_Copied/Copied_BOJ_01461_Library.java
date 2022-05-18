package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Copied_BOJ_01461_Library {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// sorting by descending way
		PriorityQueue<Integer> positiveQueue = new PriorityQueue<>((p1, p2) -> p2 - p1);
		PriorityQueue<Integer> negativeQueue = new PriorityQueue<>((p1, p2) -> p2 - p1);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());

			if (tmp > 0) {
				positiveQueue.offer(tmp);
			} else {
				negativeQueue.offer(Math.abs(tmp));
			}
		}

		// finding the farthest position
		int maxValue = 0;
		if (positiveQueue.isEmpty()) {
			maxValue = negativeQueue.peek();
		} else if (negativeQueue.isEmpty()) {
			maxValue = positiveQueue.peek();
		} else {
			maxValue = Math.max(positiveQueue.peek(), negativeQueue.peek());
		}

		int ans = 0;

		while (!positiveQueue.isEmpty()) {
			int tmp = positiveQueue.poll();
			for (int i = 0; i < M - 1; i++) {
				positiveQueue.poll();

				if (positiveQueue.isEmpty()) {
					break;
				}
			}
			ans += tmp * 2;
		}

		while (!negativeQueue.isEmpty()) {
			int tmp = negativeQueue.poll();
			for (int i = 0; i < M - 1; i++) {
				negativeQueue.poll();

				if (negativeQueue.isEmpty()) {
					break;
				}
			}
			ans += tmp * 2;
		}

		ans -= maxValue;
		System.out.println(ans);

	}

}

// reference: https://steady-coding.tistory.com/279
