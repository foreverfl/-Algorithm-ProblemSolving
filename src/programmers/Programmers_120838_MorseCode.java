package programmers;

import java.util.HashMap;
import java.util.Map;

public class Programmers_120838_MorseCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(String letter) {
		Map<String, Character> map = new HashMap<>();
		map.put(".-", 'a');
		map.put("-...", 'b');
		map.put("-.-.", 'c');
		map.put("-..", 'd');
		map.put(".", 'e');
		map.put("..-.", 'f');
		map.put("--.", 'g');
		map.put("....", 'h');
		map.put("..", 'i');
		map.put(".---", 'j');
		map.put("-.-", 'k');
		map.put(".-..", 'l');
		map.put("--", 'm');
		map.put("-.", 'n');
		map.put("---", 'o');
		map.put(".--.", 'p');
		map.put("--.-", 'q');
		map.put(".-.", 'r');
		map.put("...", 's');
		map.put("-", 't');
		map.put("..-", 'u');
		map.put("...-", 'v');
		map.put(".--", 'w');
		map.put("-..-", 'x');
		map.put("-.--", 'y');
		map.put("--..", 'z');
		String answer = "";
		String[] arr = letter.split(" ");
		for (int i = 0; i < arr.length; i++) {
			answer += map.get(arr[i]);
		}

		return answer;
	}

}
