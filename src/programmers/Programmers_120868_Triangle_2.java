package programmers;

import java.util.HashSet;
import java.util.Set;

public class Programmers_120868_Triangle_2 {

	public static void main(String[] args) {
//		System.out.println(solution(new int[] { 1, 2 }));
		System.out.println(solution(new int[] { 3, 6 }));
		System.out.println(solution(new int[] { 11, 7 }));
	}

	public static int solution(int[] sides) {
		Set<Integer> set = new HashSet<>();

		for (int i = 1; i <= 3000; i++) {
			if (isPossible(sides[0], sides[1], i))
				set.add(i);
		}
		return set.size();
	}

	private static boolean isPossible(int a, int b, int c) {
		int longest = Math.max(Math.max(a, b), c);
		int[] remains = new int[2];
		if (a == longest) {
			remains[0] = b;
			remains[1] = c;
		} else if (b == longest) {
			remains[0] = a;
			remains[1] = c;
		} else if (c == longest) {
			remains[0] = a;
			remains[1] = b;
		}

		if (longest < remains[0] + remains[1])
			return true;

		return false;
	}

}
