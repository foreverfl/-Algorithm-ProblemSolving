package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01654_CuttingLan {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];

		long max = 0; // The 'arrays.sort()' is not needless.
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		max++; // The 'max' is always over '1' to prevent the zero to be divided.

		long min = 0;
		long mid = 0;

		while (min < max) {

			mid = (max + min) / 2;
			long count = 0;
			for (int i = 0; i < arr.length; i++) {
				count += (arr[i] / mid);
			}

			if (count < N) {
				max = mid;
			} else {
				min = mid + 1;
			}

		}
		System.out.println(min - 1);
	}
}

// reference: https://st-lab.tistory.com/269
