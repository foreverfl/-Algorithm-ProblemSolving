package programmers;

public class Programmers_12985_CalcAreaOfRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[][] dots) {
		int min_x = Integer.MAX_VALUE;
		int max_x = Integer.MIN_VALUE;
		int min_y = Integer.MAX_VALUE;
		int max_y = Integer.MIN_VALUE;

		for (int i = 0; i < 4; i++) {
			min_x = Math.min(min_x, dots[i][0]);
			max_x = Math.max(max_x, dots[i][0]);
			min_y = Math.min(min_y, dots[i][1]);
			max_y = Math.max(max_y, dots[i][1]);
		}

		int answer = (max_x - min_x) * (max_y - min_y);
		return answer;
	}

}
