package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Copied_BOJ_02696_FindingMedianValue {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			int N = Integer.parseInt(br.readLine());

			sb.append((N + 1) / 2).append('\n');

			int cnt = 0;

			for (int i = 0; i < N; i++) {
				if (i % 10 == 0) {
					st = new StringTokenizer(br.readLine());
				}

				int input = Integer.parseInt(st.nextToken());

				// inputting alternately
				if (maxHeap.size() == minHeap.size()) {
					maxHeap.offer(input);
				} else {
					minHeap.offer(input);
				}

				// The 'maxHeap' always has the number below median value.
				if (!minHeap.isEmpty()) {
					if (maxHeap.peek() > minHeap.peek()) {
						int t1 = maxHeap.poll();
						int t2 = minHeap.poll();

						maxHeap.offer(t2);
						minHeap.offer(t1);
					}
				}

				if (i % 2 == 0) {
					if (cnt == 9 || i == N - 1) {
						sb.append(maxHeap.peek()).append('\n');
						cnt = 0;
					} else {
						sb.append(maxHeap.peek() + " ");
					}
					cnt++;
				}
			}
		}

		System.out.print(sb.toString());

	}

}

// reference: https://steady-coding.tistory.com/88
