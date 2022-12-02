package programmers;

public class Programmers_120912_Counting7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] array) {
		int answer = 0;
		for (int num : array) {
			String str = String.valueOf(num);
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '7')
					answer++;
			}
		}

		return answer;
	}

}
