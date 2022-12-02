package programmers;

public class Programmers_120892_DecodingPassword {

	public static void main(String[] args) {

		System.out.println(solution("dfjardstddetckdaccccdegk", 4));
	}

	public static String solution(String cipher, int code) {
		int len = cipher.length() / code;
		String answer = "";
		for (int i = code; len > 0; len--, i = i + code) {
			answer += cipher.charAt(i - 1);
		}
		return answer;
	}

}
