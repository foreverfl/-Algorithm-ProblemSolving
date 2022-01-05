package BOJ;

import java.util.Scanner;

public class Copied_BOJ_02343_GuitarLesson {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int arr[] = new int[N];
		int left = 0;
		int right = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			right += arr[i]; // The 'right' is sum of the 'arr[i]'.
			left = left < arr[i] ? arr[i] : left;
		}

		// With the 'mid', cut the blu-lay till the 'cnt' and the 'M' is same.
		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;
			int cnt = 0; // the number of the 'M'
			for (int i = 0; i < N; i++) {
				if (sum + arr[i] > mid) { // if the 'sum+arr[i]'is larger than the 'mid'
					sum = 0; // initialization
					cnt++;
				}
				sum += arr[i];
			}
			if (sum != 0) // if initialization is not executed
				cnt++;
			if (cnt <= M)
				right = mid - 1;
			else
				left = mid + 1;
		}
		System.out.println(left);
	}
}

// reference: toastfactory.tistory.com/144
