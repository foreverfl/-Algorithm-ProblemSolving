package programmers;

public class Programmers_120884_ChickenCoupon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int chicken) {

		int answer = 0;
		for (int i = 1; i <= chicken; i++) {
			if (i % 10 == 0) {
				chicken++;
				answer++;
			}
		}
		return answer;
	}
}
