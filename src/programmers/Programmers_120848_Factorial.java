package programmers;

public class Programmers_120848_Factorial {

	public static void main(String[] args) {
		System.out.println(solution(3628800));
		System.out.println(solution(7));

	}

	public static int solution(int n) {
		int[] arr = new int[11];

		int now = 1;
		for (int i = 1; i <= 10; i++) {
			now *= i;
			arr[i] = now;
		}
		if (n == 0)
			return 0;
		if (n == 3628800)
			return 10;

		int answer = 0;
		for (int i = 1; i <= 10; i++) {
			if (arr[i] > n) {
				answer = i - 1;
				break;
			}

		}

		return answer;
	}

}
