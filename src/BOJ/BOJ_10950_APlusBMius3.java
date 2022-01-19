package BOJ;

import java.util.Scanner;

public class BOJ_10950_APlusBMius3 {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();
		int arr[] = new int[input];

		for (int i = 0; i < input; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[i] = a + b;
		}
		sc.close();

		for (int a : arr) {
			System.out.println(a);
		}
	}
}
