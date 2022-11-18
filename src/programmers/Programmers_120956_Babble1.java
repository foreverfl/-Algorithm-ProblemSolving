package programmers;

public class Programmers_120956_Babble1 {

	public static void main(String[] args) {
		System.out.println(solution(new String[] { "aya", "yee", "u", "maa", "wyeoo" }));
		System.out.println(solution(new String[] { "ayaye", "uuuma", "ye", "yemawoo", "ayaa" }));

	}

	public static int solution(String[] babbling) {
		int answer = 0;

		for (int i = 0; i < babbling.length; i++) {
			if (check(babbling[i]))
				answer++;
		}

		return answer;
	}

	private static boolean check(String word) {
		String[] words = new String[] { "aya", "ye", "woo", "ma" };

		while (true) {
			int cnt = 0;
			for (int i = 0; i < words.length; i++) {
				if (word.contains(words[i])) {
					word = word.replaceFirst(words[i], " ");
					cnt++;
				}
			}

			if (cnt == 0)
				break;

		}

		if (word.trim().equals(""))
			return true;
		else
			return false;

	}

}
