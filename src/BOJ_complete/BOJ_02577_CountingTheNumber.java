package BOJ_complete;

import java.util.Scanner;

public class BOJ_02577_CountingTheNumber {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int result = a * b * c;
		String str = Integer.toString(result);
		String answer[] = str.split("");

		int arr[] = new int[10];
		int arrcheck[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < answer.length; j++) {
				if (arr[i] == Integer.parseInt(answer[j])) {
					arrcheck[i]++;
				}
			}
		}

		for (int i = 0; i < arrcheck.length; i++) {
			System.out.println(arrcheck[i]);
		}

	}
}
