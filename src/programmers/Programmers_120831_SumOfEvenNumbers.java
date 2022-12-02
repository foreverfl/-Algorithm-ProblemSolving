package programmers;

public class Programmers_120831_SumOfEvenNumbers {

	public static void main(String[] args) {
		System.out.println(solution(10));
		System.out.println(solution(4));
	}

	public static int solution(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0)
				answer += i;
		}
		return answer;
	}

}
