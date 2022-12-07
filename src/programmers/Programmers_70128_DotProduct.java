package programmers;

public class Programmers_70128_DotProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] a, int[] b) {
		int answer = 0;
		for (int i = 0; i < a.length; i++) {
			answer += (a[i] * b[i]);
		}

		return answer;
	}

}
