package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmers_120897_FindDivisor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(int n) {
		List<Integer> list = findDivisor(n);
		Collections.sort(list);
		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	private static List<Integer> findDivisor(int num) {
		int sqrt = (int) Math.sqrt(num);
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= sqrt; i++) {
			if (num % i == 0) {
				list.add(i);

				if (num / i != i) {
					list.add(num / i);
				}
			}
		}

		return list;
	}

}
