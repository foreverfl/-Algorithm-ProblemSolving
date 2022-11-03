package boj;

import java.util.Scanner;

public class BOJ_01546_Average {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double arr[] = new double[N];
		double newarr[] = new double[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextDouble();
		}

		double max = -1;
		for (int i = 0; i < N; i++) { // finding the max value
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		double sum = 0;
		for (int i = 0; i < N; i++) {
			newarr[i] = arr[i] / max * 100; // new score
			sum += newarr[i];
		}

		double avg = sum / N;
		System.out.println(avg);

	}
}
