package BOJ_complete;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14487_UkzeIsADevotedSon {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int Town[] = new int[n];
		for (int i = 0; i < n; i++) {
			Town[i] = sc.nextInt();
		}

		Arrays.sort(Town);

		int sum = 0;
		for (int i = 0; i < n - 1; i++) {
			sum += Town[i];
		}

		System.out.println(sum);

	}

}
