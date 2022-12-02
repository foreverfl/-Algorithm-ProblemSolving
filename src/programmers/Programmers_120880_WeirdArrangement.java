package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Programmers_120880_WeirdArrangement {

	public static void main(String[] args) {
		int[] arr = solution(new int[] { 1, 2, 3, 4, 5, 6 }, 4);
		System.out.println(Arrays.toString(arr));
		arr = solution(new int[] { 10000, 20, 36, 47, 40, 6, 10, 7000 }, 30);
		System.out.println(Arrays.toString(arr));
	}

	public static int[] solution(int[] numlist, int n) {
		// 역순 정렬시키기
		List<Integer> list = new LinkedList<>();
		for (int num : numlist)
			list.add(num);

		Collections.sort(list, Collections.reverseOrder());

		int[] answer = new int[list.size()];

		int idx = 0;
		while (!list.isEmpty()) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < list.size(); i++) {
				int dist = Math.abs(n - list.get(i));
				min = Math.min(min, dist);
			}

			for (int i = 0; i < list.size(); i++) {
				int dist = Math.abs(n - list.get(i));
				if (dist == min) {
					answer[idx++] = list.get(i);
					list.remove(i);
				}
			}
		}

		return answer;
	}

}
