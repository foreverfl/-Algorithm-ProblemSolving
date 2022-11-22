package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Programmers_131701_TheNumberOfSumOfContinuousPartialProgression {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 7, 9, 1, 1, 4 }));
	}

	public static int solution(int[] elements) {
		Set<Integer> set = new HashSet<>();

		int len = 0;
		while (true) {
			if (++len == elements.length + 1)
				break;

			// 원형 수열 만들기
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < elements.length; i++) {
				list.add(elements[i]);
			}

			for (int i = 0; i < len - 1; i++) {
				list.add(elements[i]);
			}

			// 합 구해서 set에 넣기
			for (int i = 0; i < list.size() - len + 1; i++) {
				int tmpSum = 0;
				for (int j = i; j < i + len; j++) {
					tmpSum += list.get(j);
				}

				if (tmpSum != 0)
					set.add(tmpSum);
			}

		}

		return set.size();
	}

}
