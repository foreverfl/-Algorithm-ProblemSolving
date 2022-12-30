package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Programmers_142085_DefenseGame {

	public static void main(String[] args) {
		System.out.println(solution(7, 3, new int[] { 4, 2, 4, 5, 3, 3, 1 }));
		System.out.println(solution(2, 4, new int[] { 3, 3, 3, 3 }));
	}

	public static int solution(int n, int k, int[] enemy) {
		int[] arr = Arrays.copyOf(enemy, enemy.length);
		Arrays.sort(arr);

		int repeat = k;
		List<Integer> list = new LinkedList<>();

		for (int i = arr.length - 1; repeat > 0; i--, repeat--) {
			list.add(arr[i]);
		}

		int answer = 0;
		for (int i = 0; i < enemy.length; i++) {
			if (list.contains(enemy[i])) {
				k--;
				list.remove(Integer.valueOf(enemy[i]));
				answer++;
				continue;
			}

			n -= enemy[i];

			if (n < 0)
				break;

			answer++;

		}
		return answer;
	}

}
