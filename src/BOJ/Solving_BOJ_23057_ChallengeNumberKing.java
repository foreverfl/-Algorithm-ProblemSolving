package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solving_BOJ_23057_ChallengeNumberKing {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

		int M = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			set.add(tmp);
			M += tmp;
		}

		int ans = M;
		for (int i = 1; i <= M; i++) {
			int now = i;

			for (int num : set) {
				if (now >= num) {
					now -= num;
				}
				if (now == 0) {
					ans--;
					break;
				}
			}

		}

		System.out.println(ans);
	}

}
