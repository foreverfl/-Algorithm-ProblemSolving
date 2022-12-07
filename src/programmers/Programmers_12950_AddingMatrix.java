package programmers;

public class Programmers_12950_AddingMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] solution(int[][] arr1, int[][] arr2) {
		int N = arr1.length;
		int M = arr1[0].length;
		int[][] answer = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return answer;
	}

}
