package programmers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Programmers_42587_Printer {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 2, 1, 3, 2 }, 2));
	}

	private static class Data {
		int num;
		int prior;

		public Data(int num, int prior) {
			this.num = num;
			this.prior = prior;
		}

		@Override
		public String toString() {
			return "Data [num=" + num + ", prior=" + prior + "]";
		}

	}

	public static int solution(int[] priorities, int location) {
		Deque<Data> deque = new ArrayDeque<>();
		for (int i = 0; i < priorities.length; i++) {
			deque.offer(new Data(i, priorities[i]));
		}

		int answer = 0;
		while (!deque.isEmpty()) {
			Data now = deque.peek();

			boolean isPrintable = true;
			Iterator<Data> iterator = deque.iterator();
			while (iterator.hasNext()) {
				Data tmp = iterator.next();
				if (tmp.equals(now))
					continue;

				if (tmp.prior > now.prior) {
					isPrintable = false;
				}
			}

			if (isPrintable) {
				Data tmp = deque.poll();
				answer++;
				if (tmp.num == location) {
					return answer;
				}

			} else {
				Data tmp = deque.poll();
				deque.offer(tmp);
			}
		}

		return answer;
	}

}
