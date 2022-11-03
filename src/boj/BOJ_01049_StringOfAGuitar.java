package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01049_StringOfAGuitar {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] package_6 = new int[M];
		int[] each = new int[M];

		int min_package_6 = Integer.MAX_VALUE;
		int min_each = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			package_6[i] = Integer.parseInt(st.nextToken());
			each[i] = Integer.parseInt(st.nextToken());

			// looking for the minimum value
			if (package_6[i] < min_package_6)
				min_package_6 = package_6[i];

			if (each[i] < min_each)
				min_each = each[i];
		}

		int result = 0;
		if (N < 6) {

			// If the price of package is cheaper than sum of each.
			if (N * min_each > min_package_6) {
				result = min_package_6;
			} else {
				result = min_each * N;
			}

		} else {

			if ((N % 6) * min_each > min_package_6) {
				result = min_package_6 * (N / 6) + min_package_6;
				
			} else {
				
				int result_tmp_1 = min_package_6 * (N / 6) + min_each * (N % 6);
				int result_tmp_2 = min_each * N;
				
				if (result_tmp_1 > result_tmp_2) {
					result = result_tmp_2;
				} else {
					result = result_tmp_1;
				}
			}

		}

		System.out.println(result);
	}

}
