package Programmers;

import java.util.ArrayList;
import java.util.List;

public class Programmers_42842_Carpet {

	public static void main(String[] args) {
		int brown_1 = 10;
		int yellow_1 = 2;
		int[] res_1 = solution(brown_1, yellow_1);
		for (int i = 0; i < 2; i++) {
			System.out.print(res_1[i] + " ");
		}
		System.out.println();

		int brown_2 = 8;
		int yellow_2 = 1;
		int[] res_2 = solution(brown_2, yellow_2);
		for (int i = 0; i < 2; i++) {
			System.out.print(res_2[i] + " ");
		}
		System.out.println();

		int brown_3 = 24;
		int yellow_3 = 24;
		int[] res_3 = solution(brown_3, yellow_3);
		for (int i = 0; i < 2; i++) {
			System.out.print(res_3[i] + " ");
		}

	}

	public static int[] solution(int brown, int yellow) {
		int[] ans = new int[2];

		List<int[]> list = new ArrayList<>();
		for (int i = 1; i <= yellow; i++) {
			if (yellow % i == 0) {
				int x = i;
				int y = yellow / i;
				list.add(new int[] { x, y });
			}
		}

		for (int i = 0; i < list.size(); i++) {
			int x = list.get(i)[0];
			int y = list.get(i)[1];

			if (2 * x + 2 * y + 4 == brown) {
				ans[0] = x + 2;
				ans[1] = y + 2;
			}

		}

		return ans;
	}

}
