package programmers;

public class Programmers_12926_Caesarcipher {

	public static void main(String[] args) {
		System.out.println(solution("a p p l e", 10));
		System.out.println(solution("AB", 1));
		System.out.println(solution("z", 1));
		System.out.println(solution("a B z", 4));
	}

	public static String solution(String s, int n) {
		String answer = "";

		for (int i = 0; i < s.length(); i++) {
			char now = ' ';
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				now = s.charAt(i);
				now += n;
				if (now > 'z') {
					now -= 26;
				}

			} else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				now = s.charAt(i);
				now += n;
				if (now > 'Z') {
					now -= 26;
				}
			} else {
				now = s.charAt(i);
			}
			answer += now;
		}
		return answer;
	}

}
