package BOJ;

import java.util.Scanner;

public class Copied_BOJ_11653_PrimeFactorizatioin {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		for (int i = 2; i <= Math.sqrt(num); i++) { // or (i * i <= num)
			while (num % i == 0) {
				System.out.println(i);
				num /= i;
			}
		}
		if (num != 1) {
			System.out.println(num);
		}
	}
}