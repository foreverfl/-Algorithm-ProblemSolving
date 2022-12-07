package programmers;

import java.util.ArrayList;
import java.util.List;

public class Programmers_AddingTheNumberOfDivisior {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int solution(int left, int right) {
		int answer = 0;
		for (int i = left; i <= right; i++) {
			if (findDivisor(i) % 2 == 0) {
				answer += i;
			} else {
				answer -= i;
			}
			
		}

		return answer;
	}

	private static int findDivisor(int num) {
		int sqrt = (int) Math.sqrt(num);
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= sqrt; i++) {
			if (num % i == 0) {
				list.add(i);

				if (num / i != i) {
					list.add(num / i);
				}
			}
		}

		return list.size();
	}
}
