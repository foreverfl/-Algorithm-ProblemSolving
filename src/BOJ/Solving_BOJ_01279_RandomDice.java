package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solving_BOJ_01279_RandomDice {

	static final int mod = 1000000007;
	static Set<Integer> set = new HashSet<>();
	static int ans;
	static int tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());

		backtracking(0, 1, M);

		System.out.println(ans % mod);

	}

	private static void backtracking(int depth, int idx, int average) {
		if (depth == 6) {
			tmp = getAverage(set);
			if (tmp < average) {
				ans++;
				set.clear();
			}

			
			return;
		}

		for (int i = idx;; i++) {
			set.add(i);
			backtracking(depth + 1, i + 1, average);
		}
	}

	private static int getAverage(Set<Integer> set) {
		int average = 0;
		int sum = 0;
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			sum += iterator.next();
		}
		average = sum / set.size();

		return average;
	}

}
