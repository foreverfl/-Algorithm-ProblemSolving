package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_02822_NAJBOLJIH5 {

	static class Problem implements Comparable<Problem> {
		int num;
		int score;

		Problem(int num, int score) {
			this.num = num;
			this.score = score;
		}

		@Override
		public int compareTo(Problem o) {
			return o.score - this.score;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Problem[] arr = new Problem[8];
		for (int i = 1; i <= 8; i++) {
			int num = i;
			int score = Integer.parseInt(br.readLine());
			arr[i - 1] = new Problem(num, score);
		}

		Arrays.sort(arr);

		int sum = 0;
		int[] ans = new int[5];
		for (int i = 0; i < 5; i++) {
			sum += arr[i].score;
			ans[i] = arr[i].num;
		}

		Arrays.sort(ans);
		System.out.println(sum);
		for (int i = 0; i < 5; i++) {
			System.out.print(ans[i] + " ");
		}
	}

}
