package programmers;

import java.util.Arrays;

public class Programmers_12982_Budget {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 3, 2, 5, 4 }, 9));
	}

	public static int solution(int[] d, int budget) {
		Arrays.sort(d);

		int answer = 0;
		int check = 0;
		for (int i = 0; i < d.length; i++) {
			check += d[i];
			answer++;

			if (check > budget) {
				answer--;
				break;
			}
		}

		return answer;
	}

}
