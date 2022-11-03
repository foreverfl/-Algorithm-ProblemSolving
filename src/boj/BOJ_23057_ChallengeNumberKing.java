package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_23057_ChallengeNumberKing {

	static int[] card = new int[21];
	static TreeSet<Integer> set = new TreeSet<>();
	static int N, M;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			M += card[i];
		}

		backTracking(0, 0);

		res = M - set.size() + 1; // excluding zero
		System.out.print(res);

	}

	public static void backTracking(int depth, int sum) {
		set.add(sum);

		if (depth == N) {
			return;
		}
		
		backTracking(depth + 1, sum);
		backTracking(depth + 1, sum + card[depth]);
		

	}
}

// reference: https://wtg-study.tistory.com/98
