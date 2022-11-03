package boj;

import java.util.Scanner;

public class BOJ_10808_CountingAlphabet {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int[] count_arr = new int[26];
		char[] check_arr = S.toCharArray();

		for (int i = 0; i < count_arr.length; i++) {
			for (int j = 0; j < check_arr.length; j++) {
				int check = check_arr[j] - 97;
				if (check == i) {
					count_arr[i]++;
				}
			}
		}

		for (int i = 0; i < count_arr.length; i++) {
			System.out.print(count_arr[i] + " ");
		}

	}
}
