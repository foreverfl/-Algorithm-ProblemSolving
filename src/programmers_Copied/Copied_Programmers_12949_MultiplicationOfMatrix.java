package programmers_Copied;

public class Copied_Programmers_12949_MultiplicationOfMatrix {

	public static void main(String[] args) {
		int[][] arr = solution(new int[][] { { 1, 4 }, { 3, 2 }, { 3, 3 } }, new int[][] { { 3, 3 }, { 3, 3 } });
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.printf("%2d ", arr[i][j]);
			}
			System.out.println();
		}
		// 2*3 2*2
	}

	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				for (int k = 0; k < arr1[0].length; k++) {
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}

		return answer;
	}

}
