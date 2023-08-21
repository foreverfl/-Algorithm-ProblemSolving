package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Divisior {
	private static int findDivisor(int num) {
		int sqrt = (int) Math.sqrt(num);
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= sqrt; i++) {
			if (num % i == 0) {
				list.add(i);

				// 쌍을 이루는 약수 추가하기
				if (num / i != i) {
					list.add(num / i);
				}
			}
		}

		return list.size();
	}

	public static void main(String... args) {
		System.out.println(findDivisor(100));
	}
}
