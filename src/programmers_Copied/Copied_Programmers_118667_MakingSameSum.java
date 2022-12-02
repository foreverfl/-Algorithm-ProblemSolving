package programmers_Copied;

import java.util.LinkedList;
import java.util.Queue;

public class Copied_Programmers_118667_MakingSameSum {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 2, 7, 2 }, new int[] { 4, 6, 5, 1 }));
		System.out.println(solution(new int[] { 1, 2, 1, 2 }, new int[] { 1, 10, 1, 2 }));
		System.out.println(solution(new int[] { 1, 1 }, new int[] { 1, 5 }));
	}

	public static int solution(int[] queue1, int[] queue2) {
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		long total = 0;
		long sum = 0;
		for (int i = 0; i < queue1.length; i++) {
			total += queue1[i];
			total += queue2[i];
			sum += queue1[i];			
			q1.add(queue1[i]);
			q2.add(queue2[i]);
		}

		int maxCount = queue1.length * 3;
		total /= 2;

		while (sum != total) {

			if (maxCount == 0) {
				return -1;
			}

			int tmp = 0;
			if (sum > total) {
				tmp = q1.poll();
				sum -= tmp;
				q2.add(tmp);
			} else {
				tmp = q2.poll();
				sum += tmp;
				q1.add(tmp);
			}

			maxCount--;
		}

		return queue1.length * 3 - maxCount;
	}

}
