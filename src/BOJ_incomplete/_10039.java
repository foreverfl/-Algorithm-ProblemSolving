package BOJ_incomplete;

import java.util.Scanner;

public class _10039 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int arr[] = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] < 40) {
				arr[i] = 40;
			}
			sum += arr[i];
		}
		System.out.println(sum / 5);
	}

}
