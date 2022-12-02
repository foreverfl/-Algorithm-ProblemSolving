package programmers;

public class Programmers_120815_DividingPizza_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int n) {
		int pizza = 0;
		int answer = 0;
		while (true) {
			answer++;
			pizza += 6;
			if (pizza % n == 0) {
				break;
			}
		}

		return answer;
	}

}
