package programmers;

public class Programmers_120822_ReverseString {

	public static void main(String[] args) {
		System.out.println(solution("jaron"));
		System.out.println(solution("bread"));

	}

	public static String solution(String my_string) {
		String answer = "";
		for (int i = my_string.length() - 1; i >= 0; i--) {
			answer += my_string.charAt(i);
		}

		return answer;
	}

}
