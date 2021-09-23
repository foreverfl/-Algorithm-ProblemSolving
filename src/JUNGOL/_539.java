package JUNGOL;

import java.util.Scanner;

public class _539 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int sum = 0, count = 0, numInput = 0;

		boolean run = true;
		while (run) {
			numInput = sc.nextInt(); // To use 'sc.nextInt()' continuously, it has to be input in the infinite loop.
			sum += numInput;
			count++; //

			if (numInput >= 100) {
				break; // 'break;' has to come first
			}

		}
		System.out.println(sum);
		System.out.printf("%.1f", sum / (float) count);
		sc.close();
	}

}
