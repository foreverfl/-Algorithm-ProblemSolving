package programmers;

public class Programmers_120862_MakingMax_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] numbers) {
		int answer = Integer.MIN_VALUE;

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (i == j)
					continue;

				answer = Math.max(answer, numbers[i] * numbers[j]);
			}
		}
		return answer;
	}

}
