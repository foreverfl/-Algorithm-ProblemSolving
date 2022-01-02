package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Copied_BOJ_02108_Statistics {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int[] arr = new int[T];
		int sum = 0;

		for (int i = 0; i < T; i++) {
			int value = Integer.parseInt(br.readLine());
			arr[i] = value;
			sum += value;
		}

		Arrays.sort(arr);

		boolean flag = false;
		int mode_max = 0;
		int mode = Integer.MAX_VALUE;

		for (int i = 0; i < T; i++) {
			int jump = 0; // caution: jump after array
			int count = 1;
			int i_value = arr[i];

			for (int j = i + 1; j < T; j++) {
				if (i_value != arr[j]) {
					break;
				}
				count++;
				jump++;
			}

			// in case that new value(count) is larger than the existing frequent
			// value(mode_max)
			if (count > mode_max) {
				mode_max = count;
				mode = i_value;
				flag = true;
			} else if (count == mode_max && flag == true) {
				mode = i_value;
				flag = false;
			}

			i += jump;
		}

		System.out.println((int) Math.round((double) sum / T));
		System.out.println(arr[T / 2]);
		System.out.println(mode);
		System.out.println(arr[T - 1] - arr[0]);

	}
}

// reference: https://st-lab.tistory.com/108