package programmers;

import java.util.ArrayList;
import java.util.List;

public class Programmers_120875_Parallel {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 1, 4 }, { 9, 2 }, { 3, 8 }, { 11, 6 } }));
		System.out.println(solution(new int[][] { { 3, 5 }, { 4, 1 }, { 2, 4 }, { 5, 10 } }));
	}

	public static int solution(int[][] dots) {

		boolean[] visited = new boolean[4];
		visited[0] = true;

		for (int i = 1; i < 4; i++) {
			visited[i] = true;

			if (isParallel(dots, visited))
				return 1;

			visited[i] = false;
		}

		return 0;
	}

	private static boolean isParallel(int[][] dots, boolean[] visited) {
		List<int[]> line1 = new ArrayList<>();
		List<int[]> line2 = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			if (visited[i]) {
				line1.add(dots[i]);
			} else {
				line2.add(dots[i]);
			}
		}

		double inclination1 = (double)(line1.get(1)[1] - line1.get(0)[1]) / (line1.get(1)[0] - line1.get(0)[0]);
		double inclination2 = (double)(line2.get(1)[1] - line2.get(0)[1]) / (line2.get(1)[0] - line2.get(0)[0]);

		if (inclination1 == inclination2)
			return true;
		else
			return false;
	}

}
