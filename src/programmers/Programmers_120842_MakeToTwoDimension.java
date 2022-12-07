package programmers;

public class Programmers_120842_MakeToTwoDimension {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] solution(int[] num_list, int n) {
		int N = num_list.length / n;
		int M = n;
		int[][] answer = new int[N][M];

		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer[i][j] = num_list[idx++];
			}
		}
		return answer;
	}

}
