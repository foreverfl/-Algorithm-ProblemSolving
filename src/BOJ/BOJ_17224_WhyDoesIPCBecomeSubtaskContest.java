package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17224_WhyDoesIPCBecomeSubtaskContest {

	static class Problem implements Comparable<Problem> {
		int easy;
		int hard;

		Problem(int easy, int hard) {
			this.easy = easy;
			this.hard = hard;
		}

		@Override
		public int compareTo(Problem o) {
			if (this.hard == o.hard)
				return this.easy - o.easy;
			return this.hard - o.hard;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Problem[] arr = new Problem[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int easy = Integer.parseInt(st.nextToken());
			int hard = Integer.parseInt(st.nextToken());
			arr[i] = new Problem(easy, hard);
		}

		Arrays.sort(arr);

		int score = 0;
		for (int i = 0; i < N; i++) {
			if (L >= arr[i].hard && K != 0) {
				score += 140;
				K--;
			} else if (L >= arr[i].easy && K != 0) {
				score += 100;
				K--;
			}

			if (K == 0)
				break;

		}

		System.out.println(score);
	}

}
