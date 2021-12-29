package BOJ;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Copied_BOJ_02309_TheSevenDwarf {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = 9;
		int[] a = new int[T];
		int sum = 0;
		for (int i = 0; i < T; i++) {
			a[i] = sc.nextInt();
			sum += a[i];
		}

		Arrays.sort(a);

		for (int i = 0; i < T; i++) {
			for (int j = i + 1; j < T; j++) {
				if (sum - a[i] - a[j] == 100) {
					for (int k = 0; k < T; k++) {
						if (i == k || j == k) {
							continue;
						}
						System.out.println(a[k]);
					}
					System.exit(0);
				}
			}
		}
	}
}

// reference: https://choseongho93.tistory.com/159