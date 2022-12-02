package programmers;

import java.util.ArrayList;
import java.util.List;

public class Programmers_120843_ThrowingBall {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 4 }, 2));
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5, 6 }, 5));
		System.out.println(solution(new int[] { 1, 2, 3 }, 3));

	}

	public static int solution(int[] numbers, int k) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < numbers.length; j++) {
				list.add(numbers[j]);
			}
		}

		int idx = 0;
		k--;
		while (k-- > 0) {
			idx += 2;
		}

		int answer = list.get(idx);
		return answer;
	}

}
