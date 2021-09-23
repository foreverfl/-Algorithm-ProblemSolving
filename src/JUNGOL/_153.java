package JUNGOL;

import java.util.Scanner;

public class _153 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int temp = 0;
		int save;

		int arr[] = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] == -1) {
				temp = i;
				break;
			}
		}

		save = temp - 3;
		for (int i = save; i < temp; i++) {
			if (i >= 0) {
				System.out.printf(arr[i] + " ");
			}
		}
		sc.close();
	}

}
