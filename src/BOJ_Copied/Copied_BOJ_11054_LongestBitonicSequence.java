package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_11054_LongestBitonicSequence {

	static Integer[] LIS;
	static Integer[] LDS;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		LIS = new Integer[N];
		LDS = new Integer[N];
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			LIS(i);
			LDS(i);
		}

		int max = -1;
		for (int i = 0; i < N; i++) {
			max = Math.max(LIS[i] + LDS[i], max);
		}
		System.out.println(max - 1);

	}

	private static int LIS(int N) {
		if (LIS[N] == null) {
			LIS[N] = 1;

			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] < arr[N]) {
					LIS[N] = Math.max(LIS[N], LIS(i) + 1);
				}
			}
		}
		return LIS[N];
	}

	private static int LDS(int N) {
		if (LDS[N] == null) {
			LDS[N] = 1;

			for (int i = N + 1; i < LDS.length; i++) {
				if (arr[i] < arr[N]) {
					LDS[N] = Math.max(LDS[N], LDS(i) + 1);
				}
			}
		}
		return LDS[N];
	}

}

// reference: https://st-lab.tistory.com/136