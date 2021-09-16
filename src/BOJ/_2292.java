package BOJ;

import java.util.Scanner;

public class _2292 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int count = 1; // a minimum route
		int range = 2; // a minimum range

		if (num == 1) {
			System.out.print(1);
		}

		else {
			while (range <= num) { // It repeats till a range become larger than the 'num.'
				range = range + (6 * count); // It initializes the 'range' as a minimum value of the next range.
				count++;
			}
			System.out.print(count);
			/* 1column: 1 ¡æ 1(0)
			 * 2column: 2~7 ¡æ 6  
			 * 3column: 8~19 ¡æ 12
			 * 4column: 20~37 ¡æ 18
			 * 5column: 38~61 ¡æ 24
			 */
			sc.close();
		}
	}
}
