package programmers_Copied;

import java.util.Collections;
import java.util.PriorityQueue;

public class Copied_Programmers_42628_DualPriorityQueue {

	public static void main(String[] args) {
		String[] operations_1 = { "I 16", "D 1" };
		int[] res_1 = solution(operations_1);
		for (int i = 0; i < res_1.length; i++) {
			System.out.print(res_1[i] + " ");
		}
		System.out.println();

		String[] operations_2 = { "I 7", "I 5", "I -5", "D -1" };
		int[] res_2 = solution(operations_2);
		for (int i = 0; i < res_2.length; i++) {
			System.out.print(res_2[i] + " ");
		}

	}

	public static int[] solution(String[] operations) {
		int[] answer = { 0, 0 };
		PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pqMin = new PriorityQueue<>();

		for (String operation : operations) {
			String[] str = operation.split(" ");

			if (str[0].equals("I")) {
				pqMax.add(Integer.parseInt(str[1]));
				pqMin.add(Integer.parseInt(str[1]));
			}

			if (str[0].equals("D")) {
				if (!pqMax.isEmpty()) {
					if (str[1].equals("1")) {
						int max = pqMax.peek();
						pqMax.remove(max);
						pqMin.remove(max);

					} else {
						int min = pqMin.peek();
						pqMax.remove(min);
						pqMin.remove(min);
					}
				}
			}

		}

		if (!pqMax.isEmpty()) {
			answer[0] = pqMax.peek();
			answer[1] = pqMin.peek();

		}
		return answer;
	}
}

// reference: https://jar100.tistory.com/21
