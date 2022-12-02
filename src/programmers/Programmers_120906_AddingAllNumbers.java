package programmers;

public class Programmers_120906_AddingAllNumbers {

	public static void main(String[] args) {
		System.out.println(solution(1234));
		System.out.println(solution(930211));
	}

	public static int solution(int n) {
		int answer = 0;

		while (n > 0) {
			answer += (n % 10);
			n /= 10;
		}

		return answer;
	}

}
