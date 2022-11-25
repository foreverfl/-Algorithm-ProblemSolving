package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solving_Programmers_138475_RememberMultiplicationTable {

	public static void main(String[] args) {
//		int[] arr = solution(8, new int[] { 1, 3, 7 });
//		System.out.println(Arrays.toString(arr));

		int[] arr = solution(5000000, new int[] { 4999999, 4999998, 4999997 });
		System.out.println(Arrays.toString(arr));

	}

	private static class Pair implements Comparable<Pair> {
		int num;
		int divisorCnt;

		public Pair(int num, int divisorCnt) {
			this.num = num;
			this.divisorCnt = divisorCnt;
		}

		@Override
		public String toString() {
			return "Pair [num=" + num + ", divisorCnt=" + divisorCnt + "]";
		}

		@Override
		public int compareTo(Pair o) {
			if (o.divisorCnt == this.divisorCnt) {
				return this.num - o.num;
			}

			return o.divisorCnt - this.divisorCnt;
		}

	}

	public static int[] solution(int e, int[] starts) {
		List<Pair> pairs = new ArrayList<>();
		pairs.add(null);

		for (int i = 1; i <= e; i++) {
			int num = i;
			int divisor = findDivisor(i);
			pairs.add(new Pair(num, divisor));
		}

		int[] answer = new int[starts.length];
		for (int i = 0; i < starts.length; i++) {
			if (starts[i] == e) {
				answer[i] = e;
				continue;
			}

			List<Pair> list = new ArrayList<>();
			for (int j = starts[i]; j <= e; j++) {
				list.add(pairs.get(j));
			}

			Collections.sort(list);
			answer[i] = list.get(0).num;
		}

		return answer;
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
