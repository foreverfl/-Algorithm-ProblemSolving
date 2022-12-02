package programmers;

import java.util.ArrayList;
import java.util.List;

public class Programmers_120836_TheNumberOfPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int n) {
		int answer = findDivisor(n);
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
