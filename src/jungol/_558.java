package jungol;

import java.util.Scanner;

public class _558 {
	public static void main(String[] args) {
		int arr[] = new int[100];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			int num = sc.nextInt();
			arr[i] = num;
			if (num == 0) {
				int j = arr.length - 1;
				for (int k = j; k >= 0; k--) {
					if (arr[k] == 0) { // The value '0' is ignored.
						continue;
					} else {
						System.out.print(arr[k] + " ");
					}
				}
				break;

			}
		}
	}
}