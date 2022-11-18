package programmers;

import java.util.Arrays;
import java.util.Collections;

public class Programmers_135808_FruitMerchant {

	public static void main(String[] args) {
		System.out.println(solution(4, 3, new int[] { 4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2 }));
		System.out.println(solution(3, 4, new int[] { 1, 2, 3, 1, 2, 3, 1 }));

	}

	public static int solution(int k, int m, int[] score) {
		int ans = 0;
		Integer[] scoreWrapped = new Integer[score.length];
		for (int i = 0; i < score.length; i++) {
			scoreWrapped[i] = score[i];
		}

		Arrays.sort(scoreWrapped, Collections.reverseOrder());

		int idx = -1;
		loop: while (true) {
			int[] box = new int[m];

			for (int i = 0; i < m; i++) {
				if (++idx > score.length - 1) {
					break;
				}

				box[i] = scoreWrapped[idx];
			}

			for (int i = 0; i < box.length; i++) {
				if (box[i] == 0) {
					break loop;
				}
			}

			ans += box[m - 1] * m;

		}

		return ans;
	}

}
