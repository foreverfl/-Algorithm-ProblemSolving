package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Programmers_68644_AddingTwoFromArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(int[] numbers) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (i == j)
					continue;

				set.add(numbers[i] + numbers[j]);
			}
		}

		int[] answer = new int[set.size()];
		Iterator<Integer> iterator = set.iterator();
		int idx = 0;
		while (iterator.hasNext()) {
			answer[idx++] = iterator.next();
		}
		
		Arrays.sort(answer);

		return answer;
	}

}
