package BOJ;

import java.util.Scanner;

public class _1978_in_progress {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int arr[] = new int[count];
		int check = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			for (int j = 2; j < arr[i];) {
				if (arr[i] % j == 0) {
					continue;
				} else {
					check++;
				}
				break;
			}
		}
		System.out.println(check);

	}

}
