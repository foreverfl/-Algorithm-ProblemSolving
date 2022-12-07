package programmers;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Programmers_42626_MoreHotter {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3 }, 11));

	}

	public static int solution(int[] scoville, int K) {
		int size = scoville.length;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int num : scoville) {
			pq.add(num);
		}

		int cnt = 0;
		int mixed = 0;
		for (int i = 0; i < size - 1; i++) {
			if (isOver(pq, K)) {
				return cnt;
			}

			cnt++;
			int A = pq.poll();
			int B = pq.poll();

			mixed = A + B * 2;
			pq.add(mixed);

		}

		if (mixed >= K) {
			return cnt;
		} else {
			return -1;
		}
	}

	private static boolean isOver(PriorityQueue<Integer> pq, int k) {
		Iterator<Integer> iterator = pq.iterator();

		while (iterator.hasNext()) {
			if (iterator.next() < k) {
				return false;
			}
		}

		return true;
	}
}
