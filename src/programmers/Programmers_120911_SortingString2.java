package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmers_120911_SortingString2 {
	public static void main(String[] args) {
		System.out.println(solution("Bcad"));
		System.out.println(solution("heLLo"));
		System.out.println(solution("Python"));

	}

	public static String solution(String my_string) {
		String lowerCase = my_string.toLowerCase();

		List<Character> list = new ArrayList<>();
		for (int i = 0; i < my_string.length(); i++) {
			list.add(lowerCase.charAt(i));
		}

		Collections.sort(list);

		String answer = "";
		for (int i = 0; i < list.size(); i++) {
			answer += list.get(i);
		}

		return answer;
	}
}
