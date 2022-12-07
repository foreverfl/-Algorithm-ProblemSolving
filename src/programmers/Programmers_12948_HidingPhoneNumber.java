package programmers;

public class Programmers_12948_HidingPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(String phone_number) {
		int size = phone_number.length();
		String answer = "";

		for (int i = 0; i < size - 4; i++) {
			answer += "*";
		}

		for (int i = size - 4; i < size; i++) {
			answer += phone_number.charAt(i);
		}
		return answer;
	}

}
