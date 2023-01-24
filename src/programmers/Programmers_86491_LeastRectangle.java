package programmers;

public class Programmers_86491_LeastRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int solution(int[][] sizes) {

		int h = -1;
		int w = -1;

		for (int i = 0; i < sizes.length; i++) {
			if (sizes[i][0] >= sizes[i][1]) {
				h = Math.max(h, sizes[i][0]);
				w = Math.max(w, sizes[i][1]);
			} else {
				h = Math.max(h, sizes[i][1]);
				w = Math.max(w, sizes[i][0]);
			}
		}

		int answer = h * w;
		return answer;
	}

}
