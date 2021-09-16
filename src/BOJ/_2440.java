package BOJ;

import java.util.Scanner;

public class _2440 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		sc.close();
		
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
