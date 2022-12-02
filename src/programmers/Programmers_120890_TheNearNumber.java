package programmers;

import java.util.Arrays;

public class Programmers_120890_TheNearNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] array, int n) {
		Arrays.sort(array);

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			int dist = Math.abs(n - array[i]);
			min = Math.min(min, dist);
		}

		for (int i = 0; i < array.length; i++) {
			int dist = Math.abs(n - array[i]);
			if (dist == min) {
				return array[i];
			}
		}

		return 0;
	}

}
