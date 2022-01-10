package BOJ;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Copied_BOJ_01715_ArrangingCards {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		PriorityQueue<Long> pq = new PriorityQueue<Long>();

		for (int i = 0; i < N; i++) {
			pq.add(sc.nextLong());
		}

		long sum = 0;
		while (pq.size() > 1) { // More than two elements are needed
			long temp1 = pq.poll();
			long temp2 = pq.poll();

			sum += temp1 + temp2;
			pq.add(temp1 + temp2); // inputting sum into the 'qu' again
		}

		System.out.println(sum);

	}
}
