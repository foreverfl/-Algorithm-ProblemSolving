package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Copied_BOJ_15678_YonseiWaterPark {

	static class Node {
		int idx;
		long data;

		public Node(int idx, long data) {
			this.idx = idx;
			this.data = data;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Node[] node = new Node[N];
		for (int i = 0; i < N; i++) {
			long data = Long.parseLong(st.nextToken());
			node[i] = new Node(i, data);
		}

		Deque<Node> deq = new ArrayDeque<>();
		long ans = Long.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			// excluding the case 'idx + D >= i'
			while (!deq.isEmpty() && deq.peekLast().idx + D < i) {
				deq.pollLast();
			}

			if (deq.isEmpty()) {
				deq.offer(node[i]);
				continue;
			}

			// node[i].data >= 0 -> renewing maximum value
			if (deq.peekLast().data <= deq.peekLast().data + node[i].data) {
				deq.addLast(new Node(i, deq.peekLast().data + node[i].data));
			}
			// node[i].data < 0 -> removing the value less than 'maximum value +
			// node[i].data' + adding
			else {
				while (deq.size() > 1 && deq.peekFirst().data <= deq.peekLast().data + node[i].data) {
					deq.pollFirst();
				}
				deq.addFirst(new Node(i, deq.peekLast().data + node[i].data));
			}

			// node[i].data is the maximum value -> adding maximum value
			if (deq.peekLast().data <= node[i].data) {
				deq.addLast(new Node(i, node[i].data));
			}
			ans = Math.max(ans, deq.peekLast().data);
		}
		System.out.println(ans);

	}

}

// reference: https://sorjfkrh5078.tistory.com/286