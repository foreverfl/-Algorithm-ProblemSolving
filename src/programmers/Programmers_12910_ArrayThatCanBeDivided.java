package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmers_12910_ArrayThatCanBeDivided {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(int[] arr, int divisor) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0)
				list.add(arr[i]);
		}

		if (list.isEmpty()) {
			return new int[] { -1 };
		}

		Collections.sort(list);
		int[] answer = new int[list.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
