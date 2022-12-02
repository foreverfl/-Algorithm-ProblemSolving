package programmers;

public class Programmers_120893_UppercaseAndLowercase {

	public static void main(String[] args) {
		System.out.println(solution("cccCCC"));

	}

	public static String solution(String my_string) {
		String answer = "";

		for (int i = 0; i < my_string.length(); i++) {
			char now = my_string.charAt(i);
			if (now >= 'a' && now <= 'z') {
				answer += (char) (now - 32);
			} else {
				answer += (char) (now + 32);
			}
		}
		return answer;
	}

}
