package BOJ;

import java.util.Scanner;

public class _2741 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;

		for (int i = 0; i < n; i++) {
			result = i;
			System.out.println(result+1);

		}

		sc.close();
	}

}
