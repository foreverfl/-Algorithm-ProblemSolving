package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02523_PrintingStars_13 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = n; i > 0; i--) {

			for (int k = 1; k <= (n - i) + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 2; i <= n; i++) {

			for (int k = 1; k <= (n - i) + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
