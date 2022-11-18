package programmers;

public class Programmers_133499_Babble2 {
	public static void main(String[] args) {
		System.out.println(solution(new String[] { "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa" }));
		System.out.println(solution(new String[] { "aya", "yee", "u", "maa" }));

	}

	public static int solution(String[] babbling) {
		int answer = 0;

		for (int i = 0; i < babbling.length; i++) {
			if (canSpeak(babbling[i]))
				answer++;
		}

		return answer;
	}

	private static boolean canSpeak(String word) {
		String[] words = new String[] { "aya", "ye", "woo", "ma" };
		String[] words_impossible = new String[] { "ayaaya", "yeye", "woowoo", "mama" };

		while (true) {
			int cnt = 0;

			for (int i = 0; i < words.length; i++) {
				if (word.contains(words_impossible[i]))
					return false;
			}

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
