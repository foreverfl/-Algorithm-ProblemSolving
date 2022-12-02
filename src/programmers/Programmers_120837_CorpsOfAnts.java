package programmers;

public class Programmers_120837_CorpsOfAnts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int hp) {
		int answer = 0;
		answer += (hp / 5);
		hp = hp % 5;
		answer += (hp / 3);
		hp = hp % 3;
		answer += hp;

		return answer;
	}

}
