package boj;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_01427_SortInSide {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String[] arr = input.split("");

		Arrays.sort(arr, Collections.reverseOrder());

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}

}
