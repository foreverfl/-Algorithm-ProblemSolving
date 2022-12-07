package programmers;

public class Programmers_120888_RemovingDuplicateStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(String my_string) {
		boolean[] lowerCase = new boolean[26];
		boolean[] upperCase = new boolean[26];
		boolean blank = false;

		String answer = "";
		for (int i = 0; i < my_string.length(); i++) {
			char now = my_string.charAt(i);

			if (Character.isLowerCase(now)) {
				if (lowerCase[now - 'a'])
					continue;

				lowerCase[now - 'a'] = true;
				answer += now;
			} else if (Character.isUpperCase(now)) {
				if (upperCase[now - 'A'])
					continue;

				upperCase[now - 'A'] = true;
				answer += now;
			} else {
				if (blank)
					continue;

				blank = true;
				answer += " ";
			}

		}

		return answer;
	}

}
