package programmers_Copied;

import java.util.Arrays;
import java.util.Comparator;

public class Copied_Programmers_42884_UnmannedCamera {
	public static void main(String[] args) {
		int[][] routes = { { -20, -15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
		int result = solution(routes);
		System.out.println(result);
	}

	public static int solution(int[][] routes) {
		int answer = 0;

		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] route1, int[] route2) {
				return route1[1] - route2[1];
			}
		});

		int cam = Integer.MIN_VALUE;

		for (int[] route : routes) {
			if (cam < route[0]) {
				cam = route[1];
				answer++;
			}
		}

		return answer;
	}
}
