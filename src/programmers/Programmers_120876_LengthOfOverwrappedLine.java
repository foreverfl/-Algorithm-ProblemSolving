package programmers;

public class Programmers_120876_LengthOfOverwrappedLine {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 1 }, { 2, 5 }, { 3, 9 } }));
		System.out.println(solution(new int[][] { { -1, 1 }, { 1, 3 }, { 3, 9 } }));
		System.out.println(solution(new int[][] { { 0, 5 }, { 3, 9 }, { 1, 10 } }));

	}

	public static int solution(int[][] lines) {
		boolean[][] check = new boolean[3][201];
		for (int i = 0; i < 3; i++) {
			for (int j = lines[i][0] + 100; j < lines[i][1] + 100; j++) {
				check[i][j] = true;
			}
		}

		int answer = 0;
		for (int i = 0; i <= 200; i++) {
			if ((check[0][i] && check[1][i]) || (check[1][i] && check[2][i]) || (check[0][i] && check[2][i]))
				answer++;
		}

		return answer;
	}

}
