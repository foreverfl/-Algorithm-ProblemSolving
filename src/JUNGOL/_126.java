package JUNGOL;

import java.util.Scanner;

// If a problem can be solved without an array, using the array is not recommended.

public class _126 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a;
		int even = 0;
		int odd = 0;

		do {
			a = sc.nextInt();
			if (a % 2 == 0) {
				even++;
			} else {
				odd++;
			}

		} while (a != 0); // It outputs input valuables.
		sc.close();

		System.out.println("odd : " + odd);
		System.out.println("even : " + (even-1));
	}

}
