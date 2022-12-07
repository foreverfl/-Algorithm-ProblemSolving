package programmers;

public class Programmers_12922_Watermelon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(int n) {
		String answer = "";

		for (int i = 1; i <= n; i++) {
			if (i % 2 == 1) {
				answer += "수";
			} else {
				answer += "박";
			}
		}

		return answer;
	}

}
