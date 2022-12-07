package programmers;

public class Programmers_120887_TheNumberOfK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int i, int j, int k) {
		int answer = 0;

		for (int x = i; x <= j; x++) {
			String str = String.valueOf(x);
			for (int y = 0; y < str.length(); y++) {
				if (str.charAt(y) - '0' == k)
					answer++;
			}
		}
		return answer;
	}

}
