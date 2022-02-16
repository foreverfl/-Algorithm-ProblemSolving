package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_02579_ClimbingStairs {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] DP = new int[N + 1]; // the array for an answer
		int[] arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		DP[1] = arr[1];

		if (N >= 2) {
			DP[2] = arr[1] + arr[2]; // The 'DP[2]' has only one case.
		}

		for (int i = 3; i <= N; i++) {
			DP[i] = Math.max(DP[i - 2], DP[i - 3] + arr[i - 1]) + arr[i];
		}

		System.out.println(DP[N]);

	}

}

// reference: https://st-lab.tistory.com/132