package programmers;

import java.util.ArrayList;
import java.util.List;

public class Programmers_120913_SavingAsArrayAfterCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String[] solution(String my_str, int n) {
		List<String> list = new ArrayList<>();

		int start = 0;
		int end = n;
		while (true) {
			list.add(my_str.substring(start, end));
			start += n;
			end += n;

			if (end > my_str.length()) {
				end = my_str.length();
				list.add(my_str.substring(start, end));
				break;
			}

		}

		while (list.contains("")) {
			list.remove("");
		}

		String[] answer = new String[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
