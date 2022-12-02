package programmers;

import java.util.ArrayList;
import java.util.List;

public class Programmers_12928_SumOfDivisors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int solution(int n) {
		int answer = 0;
		List<Integer> list = findDivisor(n);
		for (int num : list) {
			answer += num;
		}

		return answer;
	}

	private static List<Integer> findDivisor(int num) {
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

		return list;
	}

}
