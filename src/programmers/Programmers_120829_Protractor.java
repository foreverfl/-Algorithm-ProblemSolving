package programmers;

public class Programmers_120829_Protractor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int angle) {
		if (angle > 0 && angle < 90)
			return 1;
		else if (angle == 90)
			return 2;
		else if (angle > 90 && angle < 180)
			return 3;
		else if (angle == 180)
			return 4;

		return 0;
	}
}
