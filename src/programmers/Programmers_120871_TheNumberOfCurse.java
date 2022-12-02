package programmers;

public class Programmers_120871_TheNumberOfCurse {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + " / " + solution(i));
		}
	}

	public static int solution(int n) {
		int repeat = n;
		int answer = 0;
		while (repeat-- > 0) {
			answer++;
			while (isCursed(answer)) {
				answer++;
			}
		}
		return answer;
	}

	private static boolean isCursed(int num) {
		if (num % 3 == 0) {
			return true;
		}

		String str = Integer.toString(num);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '3') {
				return true;
			}
		}

		return false;
	}

}
