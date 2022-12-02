package programmers;

public class Programmers_120851_AddingHidedNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(String my_string) {
		int answer = 0;
		for (int i = 0; i < my_string.length(); i++) {
			if ((my_string.charAt(i) >= '1') && (my_string.charAt(i) <= '9')) {
				answer += my_string.charAt(i) - '0';
			}
		}
		return answer;
	}
}
