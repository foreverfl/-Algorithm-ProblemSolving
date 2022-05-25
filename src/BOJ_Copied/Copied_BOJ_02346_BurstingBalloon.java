package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Copied_BOJ_02346_BurstingBalloon {

	static class Balloon {
		int idx;
		int move;

		Balloon(int idx, int move) {
			this.idx = idx;
			this.move = move;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		Deque<Balloon> deque = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());

		Balloon[] arr = new Balloon[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new Balloon(i + 1, Integer.parseInt(st.nextToken()));
		}

		// the first
		sb.append("1 ");
		int move = arr[0].move;

		// the remains
		for (int i = 1; i < N; i++) {
			deque.addLast(new Balloon(i + 1, arr[i].move));
		}

		while (!deque.isEmpty()) {
			if (move > 0) {
				for (int i = 1; i < move; i++) {
					deque.addLast(deque.poll());
				}

				Balloon nxt = deque.poll();
				move = nxt.move;
				sb.append(nxt.idx + " ");

			} else {
				for (int i = 1; i < -move; i++) {
					deque.addFirst(deque.pollLast());
				}

				Balloon nxt = deque.pollLast();
				move = nxt.move;
				sb.append(nxt.idx + " ");
			}
		}

		System.out.println(sb.toString());

	}

}

// reference: https://loosie.tistory.com/453