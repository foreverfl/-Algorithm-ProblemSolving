package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Copied_BOJ_01655_TellingTheMiddle {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

		for (int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());

			if (minHeap.size() == maxHeap.size())
				maxHeap.offer(num);
			else
				minHeap.offer(num);

			// swapping the 'minHeap' for the 'maxHeap'
			if (!minHeap.isEmpty() && !maxHeap.isEmpty())
				if (minHeap.peek() < maxHeap.peek()) {
					int tmp = minHeap.poll();
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(tmp);
				}

			sb.append(maxHeap.peek() + "\n");
		}
		System.out.println(sb);
	}
}

// reference: https://dragon-h.tistory.com/6

/*
 * max min [5 8] [10 3] ?????????
 * 
 * int tmp = minHeap.poll(); [5 8] [10] tmp = 3
 * 
 * minHeap.offer(maxHeap.poll()); [5] [8 10]
 * 
 * maxHeap.offer(tmp); [3 5] [8 10]
 */
