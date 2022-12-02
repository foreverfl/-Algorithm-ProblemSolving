package programmers;

public class Programmers_120834_AgeOfAlien {

	public static void main(String[] args) {
		System.out.println(solution(23));

	}

	public static String solution(int age) {
		String str = Integer.toString(age);

		String answer = "";
		for (int i = 0; i < str.length(); i++) {
			answer += (char) (str.charAt(i) + 49);
		}

		return answer;
	}
}
