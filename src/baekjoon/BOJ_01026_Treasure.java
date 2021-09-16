package baekjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_01026_Treasure {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int arr1[] = new int[T];
		Integer arr2[] = new Integer[T];
		int arr3[] = new int[T];
		int sum = 0;

		for (int i = 0; i < T; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < T; i++) {
			arr2[i] = sc.nextInt();
		}

		Arrays.sort(arr1);
		Arrays.sort(arr2, Collections.reverseOrder());

		for (int i = 0; i < T; i++) {
			arr3[i] = arr1[i] * arr2[i];
			sum += arr3[i];
		}
		System.out.println(sum);
	}
}
