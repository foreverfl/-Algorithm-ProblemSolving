package algorithm;

import java.util.Scanner;

public class LIS {

	static int N;
	static int[] arr, dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		dp = new int[N];
		int LIS = 0;

		for (int i = 0; i < N; i++) {
			int idx = binarySearch(arr[i], 0, LIS, LIS + 1);

			if (idx == -1) {
				dp[LIS++] = arr[i];
			} else {
				dp[idx] = arr[i];
			}
		}

		System.out.println(LIS);

		sc.close();
	}

	private static int binarySearch(int num, int start, int end, int size) {
		int res = 0;
		while (start <= end) {
			int mid = (start + end) / 2;

			if (num <= dp[mid]) {
				res = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		if (start == size) {
			return -1;
		} else {
			return res;
		}
	}
}

// reference: https://sskl660.tistory.com/89