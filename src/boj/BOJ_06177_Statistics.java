package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_06177_Statistics {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		double mean = 0;
		long total = 0;
		for (int i = 0; i < N; i++) {
			total += arr[i];
		}

		mean = (double) total / N;

		double median = 0;

		if (N == 2) {
			median = (double) (arr[0] + arr[1]) / 2;
		} else {
			if (N % 2 == 1) {
				median = arr[N / 2];
			} else {
				median = (double) (arr[N / 2] + arr[N / 2 - 1]) / 2;
			}
		}

		System.out.printf("%.6f \n", mean);
		System.out.printf("%.6f", median);
	}

}
