package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02851_SuperMario {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] sum = new int[11];
		for (int i = 1; i <= 10; i++) {
			sum[i] = Integer.parseInt(br.readLine()) + sum[i - 1];
		}

		if (sum[10] <= 100) {
			System.out.println(sum[10]);
		}

		for (int i = 1; i <= 10; i++) {
			if (sum[i] > 100) {
				if (Math.abs(sum[i - 1] - 100) > Math.abs(sum[i] - 100)) {
					System.out.println(sum[i]);
				} else if (Math.abs(sum[i - 1] - 100) < Math.abs(sum[i] - 100)) {
					System.out.println(sum[i - 1]);
				} else {
					System.out.println(sum[i]);
				}
				break;
			}
		}
	}

}
