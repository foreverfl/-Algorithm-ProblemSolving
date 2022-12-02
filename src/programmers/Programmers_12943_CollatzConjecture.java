package programmers;

public class Programmers_12943_CollatzConjecture {

	public static void main(String[] args) {
		System.out.println(solution(626331));
	}

	public static int solution(int num) {
		if (num == 1)
			return 0;

		long number = num;
		int answer = 0;
		while (true) {
			answer++;
			if (number % 2 == 0) {
				number /= 2;
			} else {
				number = number * 3 + 1;
			}

			if (answer >= 500) {
				return -1;
			}

			if (number == 1)
				break;
		}

		return answer;
	}
}
