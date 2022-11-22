package programmers;

import java.util.HashMap;
import java.util.Map;

public class Programmers_118666_MBTI {

	public static void main(String[] args) {
		System.out.println(solution(new String[] { "AN", "CF", "MJ", "RT", "NA" }, new int[] { 5, 3, 2, 7, 5 }));
		System.out.println(solution(new String[] { "TR", "RT", "TR" }, new int[] { 7, 1, 3 }));
	}

	public static String solution(String[] survey, int[] choices) {

		// RT / CF / JM / AN
		Map<Character, Integer> types = new HashMap<>();
		types.put('R', 0);
		types.put('T', 0);
		types.put('C', 0);
		types.put('F', 0);
		types.put('J', 0);
		types.put('M', 0);
		types.put('A', 0);
		types.put('N', 0);

		for (int i = 0; i < survey.length; i++) {
			if (survey[i].equals("RT")) {
				if (choices[i] >= 5) {
					types.put('T', types.get('T') + choices[i] - 4);
				} else if (choices[i] <= 3) {
					types.put('R', types.get('R') + 4 - choices[i]);
				}
			} else if (survey[i].equals("TR")) {
				if (choices[i] >= 5) {
					types.put('R', types.get('R') + choices[i] - 4);
				} else if (choices[i] <= 3) {
					types.put('T', types.get('T') + 4 - choices[i]);
				}
			} else if (survey[i].equals("CF")) {
				if (choices[i] >= 5) {
					types.put('F', types.get('F') + choices[i] - 4);
				} else if (choices[i] <= 3) {
					types.put('C', types.get('C') + 4 - choices[i]);
				}
			} else if (survey[i].equals("FC")) {
				if (choices[i] >= 5) {
					types.put('C', types.get('C') + choices[i] - 4);
				} else if (choices[i] <= 3) {
					types.put('F', types.get('F') + 4 - choices[i]);
				}
			} else if (survey[i].equals("JM")) {
				if (choices[i] >= 5) {
					types.put('M', types.get('M') + choices[i] - 4);
				} else if (choices[i] <= 3) {
					types.put('J', types.get('J') + 4 - choices[i]);
				}
			} else if (survey[i].equals("MJ")) {
				if (choices[i] >= 5) {
					types.put('J', types.get('J') + choices[i] - 4);
				} else if (choices[i] <= 3) {
					types.put('M', types.get('M') + 4 - choices[i]);
				}
			} else if (survey[i].equals("AN")) {
				if (choices[i] >= 5) {
					types.put('N', types.get('N') + choices[i] - 4);
				} else if (choices[i] <= 3) {
					types.put('A', types.get('A') + 4 - choices[i]);
				}
			} else if (survey[i].equals("NA")) {
				if (choices[i] >= 5) {
					types.put('A', types.get('A') + choices[i] - 4);
				} else if (choices[i] <= 3) {
					types.put('N', types.get('N') + 4 - choices[i]);
				}
			}
		}

		// RT / CF / JM / AN
		// RT
		String answer = "";
		if (types.get('R') > types.get('T')) {
			answer += "R";
		} else if (types.get('R') < types.get('T')) {
			answer += "T";
		} else {
			answer += "R";
		}

		// CF
		if (types.get('C') > types.get('F')) {
			answer += "C";
		} else if (types.get('C') < types.get('F')) {
			answer += "F";
		} else {
			answer += "C";
		}

		// JM
		if (types.get('J') > types.get('M')) {
			answer += "J";
		} else if (types.get('J') < types.get('M')) {
			answer += "M";
		} else {
			answer += "J";
		}

		// AN
		if (types.get('A') > types.get('N')) {
			answer += "A";
		} else if (types.get('A') < types.get('N')) {
			answer += "N";
		} else {
			answer += "A";
		}

		return answer;
	}
}
