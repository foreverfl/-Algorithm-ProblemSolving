package BOJ_complete;

import java.util.Scanner;

public class BOJ_04344_AboveAverage {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt(); // test case

		for (int i = 0; i < C; i++) {
			int N = sc.nextInt(); // the number of a class
			int arr[] = new int[N];
			int sum = 0;
			int avg = 0;
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
				sum += arr[j];

			}
			avg = sum / N;
			for (int j = 0; j < N; j++) {
				if (arr[j] > avg) {
					cnt++;
				}
			}
			double result = ((double)cnt / N) * 100;
			System.out.printf("%.3f%%\n", result); // %% ¡æ %
			sum = 0;
			avg = 0;
			cnt = 0;
		}

	}

}
