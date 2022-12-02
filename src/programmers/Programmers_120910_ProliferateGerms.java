package programmers;

public class Programmers_120910_ProliferateGerms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int n, int t) {
		int answer = n;
		for (int i = 0; i < t; i++) {
			answer *= 2;
		}
		return answer;
	}
}
