package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_01758_PartTimerGangho {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());
		Long[] arr = new Long[(int) N];

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		Arrays.sort(arr, Collections.reverseOrder());

		long ans = 0;

		for (long i = 0; i < N; i++) {
			long tmp = arr[(int) i] - i;

			if (tmp > 0)
				ans += tmp;

		}

		System.out.println(ans);

	}

}
