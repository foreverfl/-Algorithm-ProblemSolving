package programmers;

public class Programmers_120841_FindingPositionOfPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] dot) {
		if (dot[0] > 0 && dot[1] > 0)
			return 1;
		else if (dot[0] < 0 && dot[1] > 0)
			return 2;
		else if (dot[0] < 0 && dot[1] < 0)
			return 3;
		else if (dot[0] > 0 && dot[1] < 0)
			return 4;

		return 0;
	}

}
