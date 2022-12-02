package programmers;

public class Programmers_12932_ReversingNaturalNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(long n) {
		String str = Long.toString(n);

		int[] answer = new int[str.length()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = str.charAt(str.length() - 1 - i) - '0';
		}

		return answer;
	}

}
