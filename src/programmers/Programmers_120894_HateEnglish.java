package programmers;

import java.util.HashMap;
import java.util.Map;

public class Programmers_120894_HateEnglish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long solution(String numbers) {
		Map<String, String> map = new HashMap<>();

		map.put("zero", "0");
		map.put("one", "1");
		map.put("two", "2");
		map.put("three", "3");
		map.put("four", "4");
		map.put("five", "5");
		map.put("six", "6");
		map.put("seven", "7");
		map.put("eight", "8");
		map.put("nine", "9");

		String answer = "";
		String tmp = "";
		for (int i = 0; i < numbers.length(); i++) {
			tmp += numbers.charAt(i);

			if (map.containsKey(tmp)) {
				answer += map.get(tmp);
				tmp = "";
			}
		}

		return Long.valueOf(answer);
	}
}
