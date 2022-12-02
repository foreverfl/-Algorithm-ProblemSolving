package programmers;

import java.util.ArrayList;
import java.util.List;

public class Programmers_120813_HateEvenNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 1)
				list.add(i);
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
