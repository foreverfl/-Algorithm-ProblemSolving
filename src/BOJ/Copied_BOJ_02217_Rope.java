package BOJ;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Copied_BOJ_02217_Rope {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), result = 0;

		Integer[] weigh = new Integer[T];
		for (int i = 0; i < T; i++) {
			weigh[i] = sc.nextInt();
		}
		Arrays.sort(weigh, Collections.reverseOrder());

		for (int k = 1; k <= T; k++) {
			result = Math.max(result, weigh[k - 1] * k); // the max value within some of the 'weight * k'
		}
		System.out.println(result);
	}
}