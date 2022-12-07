package programmers;

public class Programmers_12903_GettingCenterStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(String s) {
		String answer = "";
		if (s.length() % 2 == 1) {
			answer += s.charAt(s.length() / 2);
		} else {
			answer += s.charAt(s.length() / 2 - 1);
			answer += s.charAt(s.length() / 2);
		}

		return answer;
	}

}
