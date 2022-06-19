import java.util.Collections;
import java.util.PriorityQueue;

public class tmp {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq_1 = new PriorityQueue<>();
		PriorityQueue<Integer> pq_2 = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < 10; i++) {
			pq_1.offer(i);
			pq_2.offer(i);
		}

		pq_1.remove(5);
		pq_2.remove(5);

		while (!pq_1.isEmpty()) {
			System.out.print(pq_1.poll() + " ");
		}

		System.out.println();

		while (!pq_2.isEmpty()) {
			System.out.print(pq_2.poll() + " ");
		}

	}

}
