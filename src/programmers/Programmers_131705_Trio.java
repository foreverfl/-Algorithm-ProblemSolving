package programmers;

public class Programmers_131705_Trio {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { -2, 3, 0, 2, -5 }));
		System.out.println(solution(new int[] { -3, -2, -1, 0, 1, 2, 3 }));
		System.out.println(solution(new int[] { -1, 1, -1, 1 }));

	}

	private static int ans;
	private static int[] students;
	private static boolean[] visited;

	public static int solution(int[] number) {
		ans = 0;
		int size = number.length;
		students = new int[size];
		for (int i = 0; i < size; i++) {
			students[i] = number[i];
		}

		visited = new boolean[size];

		backTracking(0, size, 3);
		return ans;
	}

	private static void backTracking(int depth, int n, int r) {
		if (r == 0) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (visited[i])
					sum += students[i];
			}

			if (sum == 0)
				ans++;

			return;
		}

		for (int i = depth; i < n; i++) {
			visited[i] = true;
			backTracking(i + 1, n, r - 1);
			visited[i] = false;
		}
	}

}
