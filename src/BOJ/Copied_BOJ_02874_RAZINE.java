package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_02874_RAZINE {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			int score = Integer.parseInt(br.readLine());
			arr[i] = score;
		}

		if (N == 1) { // If the number of N is '1', operation is needless.
			System.out.print(0);
		} else {
			int cnt = 0;

			for (int i = N - 2; i >= 0; i--) {
				int highLevel = arr[i + 1];
				int lowLevel = arr[i];

				if (lowLevel >= highLevel) {
					cnt += lowLevel - (highLevel - 1);
					arr[i] = highLevel - 1;
				}
			}

			System.out.print(cnt);
		}
	}
}

// reference: https://maivve.tistory.com/200