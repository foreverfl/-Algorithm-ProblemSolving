package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solving_BOJ_01279_RandomDice {

	static final int mod = 1000000007;
	static boolean[] visited;
	static Set<Set<Integer>> set = new HashSet<>();
	static int M;
	static int max, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		max = M * 6;

		visited = new boolean[max];
		backTracking(1, 0);

		System.out.println(set.size() % mod);

	}

	public static void backTracking(int depth, int sum) {
		if (depth == 7) {
			if (sum < max) {
				Set<Integer> tmp = new HashSet<>();
				for (int i = 0; i < max; i++) {
					if (visited[i]) {
						tmp.add(i);
					}
				}
				set.add(tmp);

			}

			return;
		}

		for (int i = 1; i < max; i++) {
			if (!visited[i]) {
				visited[i] = true;
				backTracking(depth + 1, sum + i);
				visited[i] = false;
			}
		}
	}

}
