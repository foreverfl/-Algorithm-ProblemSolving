package algorithm;

public class RotateArray {
	public static void main(String[] args) {
		int idx = 1;
		int[][] arr = new int[7][7];

		int start = 0;
		int end = arr.length;
		while (true) {
			for (int i = start; i < end; i++) {
				arr[start][i] = idx++;
			}
			for (int i = start + 1; i < end; i++) {
				arr[i][end - 1] = idx++;
			}
			for (int i = end - 2; i >= start; i--) {
				arr[end - 1][i] = idx++;
			}
			for (int i = end - 2; i > start; i--) {
				arr[i][start] = idx++;
			}
			start++;
			end--;
			if (start >= end)
				break;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%3d ", arr[i][j]);
			}
			System.out.println();
		}

	}
}
