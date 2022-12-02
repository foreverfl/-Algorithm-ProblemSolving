package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Programmers_138477_TheHallOfFame {

	public static void main(String[] args) {
		int[] arr = solution(3, new int[] { 10, 100, 20, 150, 1, 100, 200 });
		System.out.println(Arrays.toString(arr));

		arr = solution(4, new int[] { 0, 300, 40, 300, 20, 70, 150, 50, 500, 1000 });
		System.out.println(Arrays.toString(arr));

	}

	public static int[] solution(int k, int[] score) {
		int[] answer = new int[score.length];

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < score.length; i++) {
			list.add(score[i]);
			Collections.sort(list, Collections.reverseOrder());

			if (list.size() <= k) {
				answer[i] = list.get(i);
			} else {
				list = cutList(list, k);
				answer[i] = list.get(k - 1);
			}

		}
		return answer;
	}

	private static List<Integer> cutList(List<Integer> list, int k) {
		list.remove(k);
		return list;
	}

}
