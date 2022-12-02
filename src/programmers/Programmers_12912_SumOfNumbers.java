package programmers;

public class Programmers_12912_SumOfNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long solution(int a, int b) {
		int min = Math.min(a, b);
		int max = Math.max(a, b);

		long answer = 0;
		for (int i = min; i <= max; i++) {
			answer += i;
		}

		return answer;
	}
}
