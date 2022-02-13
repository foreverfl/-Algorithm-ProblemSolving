package BOJ_Copied;

import java.util.Arrays;
import java.util.Scanner;

public class Copied_BOJ_02512_Budget {
	private static int[] arr;
	private static long answer = 0;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		long M = sc.nextLong();
		long left = 0;
		long right = arr[N - 1];
		while (left <= right) { // finding the point that the 'left' is equal to the 'right'.
			long mid = (left + right) / 2; // The 'mid' is an upper limit.
			long sum = 0;
			for (int money : arr) {
				if (money >= mid)
					sum += mid;
				else
					sum += money;
			}
			
			// binary search
			if (sum > M) {
				right = mid - 1;
			} else {
				left = mid + 1;
				answer = Math.max(answer, mid);
			}
		}
		System.out.println(answer);
	}
}

// reference: https://youngest-programming.tistory.com/502
