package programmers;

public class Programmers_120891_369 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int order) {
		String str = String.valueOf(order);

		int answer = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) - '0' == 3 || str.charAt(i) - '0' == 6 || str.charAt(i) - '0' == 9)
				answer++;
		}
		return answer;
	}
}
