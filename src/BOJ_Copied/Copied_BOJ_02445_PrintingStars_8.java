package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_02445_PrintingStars_8 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			for (int k = 1; k <= 2 * (n - i); k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = n - 1; i > 0; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			for (int k = 1; k <= 2 * (n - i); k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}

// reference: https://alpyrithm.tistory.com/224
