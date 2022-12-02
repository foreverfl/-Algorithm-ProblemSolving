package programmers;

import java.util.ArrayList;
import java.util.List;

public class Programmers_120905_ChoosingMultipleOfN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(int n, int[] numlist) {

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < numlist.length; i++) {
			if (numlist[i] % n == 0)
				list.add(numlist[i]);
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

}
