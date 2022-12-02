package programmers;

public class Programmers_120814_DividingPizza {

	public static void main(String[] args) {
		System.out.println(solution(7));
		System.out.println(solution(1));
		System.out.println(solution(15));
	}

	public static int solution(int n) {
		int ans = 0;
		if (n % 7 == 0)
			ans = n / 7;
		else
			ans = n / 7 + 1;

		return ans;
	}

}
