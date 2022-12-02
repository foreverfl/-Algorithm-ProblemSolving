package programmers;

public class Programmers_120864_AddingHidedNumbers {

	public static void main(String[] args) {
		System.out.println(solution("aAb1B2cC34oOp"));
		System.out.println(solution("a1b23"));

	}

	public static int solution(String my_string) {
		int answer = 0;
		String tmp = "";
		boolean isNumber = true;
		for (int i = 0; i < my_string.length(); i++) {
			if (Character.isDigit(my_string.charAt(i))) {
				tmp += my_string.charAt(i);
				isNumber = true;
			} else {
				isNumber = false;
			}

			if (!isNumber) {
				if (!tmp.equals("")) {
					answer += Integer.parseInt(tmp);
					tmp = "";
				}
			}
		}
		
		if (!tmp.equals("")) {
			answer += Integer.parseInt(tmp);
			tmp = "";
		}

		return answer;
	}
}
