package programmers;

import java.util.ArrayList;
import java.util.List;

public class Programmers_136798_WeaponsOfKnights {

	public static void main(String[] args) {
		System.out.println(solution(10, 3, 2));
		System.out.println(solution(5, 3, 2));

	}

	public static int solution(int number, int limit, int power) {

		int[] knights = new int[number + 1];
		for (int i = 1; i <= number; i++) {
			knights[i] = i;
		}

		int ans = 0;

		int[] weapons = new int[number + 1];
		for (int i = 1; i <= number; i++) {
			weapons[i] = findDivisor(knights[i]);
			if (weapons[i] > limit)
				weapons[i] = power;

			ans += weapons[i];
		}

		return ans;
	}

	public static int findDivisor(int num) {
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
