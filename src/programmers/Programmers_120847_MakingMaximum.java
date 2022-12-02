package programmers;

import java.util.Arrays;

public class Programmers_120847_MakingMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] numbers) {
		Arrays.sort(numbers);

		return numbers[numbers.length - 1] * numbers[numbers.length - 2];
	}

}
