package jungol;

import java.util.Scanner;

public class _1303 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		int width = sc.nextInt();
		sc.close();
		int num = 0;
		int arr[][] = new int[height][width];


		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				num++;
				arr[i][j] = num;
				System.out.print(arr[i][j] + " "); // It outputs the double-dimensional array.
			}
			System.out.println();

		}

	}

}
