package Programmers_Copied;

import java.util.ArrayList;
import java.util.List;

public class Copied_Programmers_12981_EnglishWordChainGame {

	public static void main(String[] args) {
		int n = 2;
		String[] words = { "hello", "one", "even", "never", "now", "world", "draw" };
		int[] result = solution(n, words);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

	public static int[] solution(int n, String[] words) {

		int[] answer = new int[2];
		
		List<String> list = new ArrayList<>();
		boolean flag = true;

		for (int i = 0; i < words.length; i++) {
			// If there is a word which appeared before.
			if (list.contains(words[i])) {
				answer[0] = (i % n) + 1; // when
 				answer[1] = (i / n) + 1; // who
				flag = false;
				break;
			}

			list.add(words[i]);

			// If there is a wrong answer.
			if (i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
				answer[0] = (i % n) + 1;
				answer[1] = (i / n) + 1;
				flag = false;
				break;
			}
		}
		if (flag)
			return new int[] { 0, 0 };
		return answer;
	}

}

// reference: https://zzang9ha.tistory.com/198
