package algorithm;

public class Combination {
	public static void main(String[] args) {
		int n = 4;
		int[] arr = { 1, 2, 3, 4 };
		boolean[] visited = new boolean[n];

		for (int i = 1; i <= n; i++) {
			System.out.println("\n" + n + "개 중에서 " + i + "개 뽑기");
			backTracking(arr, visited, 0, n, i);
		}
	}

	private static void backTracking(int[] arr, boolean[] visited, int depth, int n, int r) {
		if (r == 0) {
			print(arr, visited, n);
			return;
		}

		for (int i = depth; i < n; i++) {
			visited[i] = true;
			backTracking(arr, visited, i + 1, n, r - 1);
			visited[i] = false;
		}
	}

	private static void print(int[] arr, boolean[] visited, int n) {
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				System.out.printf("%-2d", arr[i]);
			}
		}
		System.out.println();
	}
}
