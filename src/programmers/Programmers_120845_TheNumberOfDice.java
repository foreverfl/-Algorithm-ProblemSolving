package programmers;

public class Programmers_120845_TheNumberOfDice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] box, int n) {
		int horizontal = box[0] / n;
		int vertical = box[1] / n;
		int height = box[2] / n;
		int answer = horizontal * vertical * height;
		return answer;
	}
}
