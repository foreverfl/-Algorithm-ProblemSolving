package programmers;

public class Programmers_12931_AddingAllDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int n) {
		String str = Integer.toString(n);
		int answer = 0;
		for (int i = 0; i < str.length(); i++) {
			answer += (str.charAt(i) - '0');
		}

		return answer;
	}

}
