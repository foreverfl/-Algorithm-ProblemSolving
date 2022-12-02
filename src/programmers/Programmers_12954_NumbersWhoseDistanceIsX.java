package programmers;

public class Programmers_12954_NumbersWhoseDistanceIsX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long[] solution(int x, int n) {
		long now = x;
		long[] answer = new long[n];
		for (int i = 0; i < n; i++) {
			answer[i] = now;
			now = now + x;
		}

		return answer;
	}
}
