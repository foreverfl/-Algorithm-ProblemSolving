package jungol;

import java.util.Scanner;

public class _127 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = 0, sum = 0, count = 0;

		while (true) {
			input = sc.nextInt();
			if (input > 100 || input < 0)
				break;
			sum += input;
			count++;
		}
		// Controlling place of the 'break' statement is important.
		sc.close();
		System.out.println("sum : " + sum);
		System.out.printf("avg : %.1f", (float) sum / count);

	}

}
