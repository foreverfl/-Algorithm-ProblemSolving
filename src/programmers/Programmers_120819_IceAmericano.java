package programmers;

public class Programmers_120819_IceAmericano {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(int money) {
		int[] answer = new int[2];
		answer[0] = money / 5500;
		answer[1] = money % 5500;
		return answer;
	}
}
