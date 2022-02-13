package BOJ;

import java.util.Scanner;

public class BOJ_01789_SumOfNumbers {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		long check = sc.nextLong();
		long sum = 0;
		long cnt = 0;

		for (int i = 1;; i++) {
			sum += i;
			cnt++;
			if (sum <= check) {
				continue;
			} else {
				break;
			}
		}

		System.out.println(cnt-1);
	}

}
