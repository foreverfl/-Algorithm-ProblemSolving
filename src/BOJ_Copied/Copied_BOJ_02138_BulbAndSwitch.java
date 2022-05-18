package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_02138_BulbAndSwitch {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String now = br.readLine();
		String expect = br.readLine();

		int[] now_on = new int[N];
		int[] now_off = new int[N];
		int[] expect_arr = new int[N];

		for (int i = 0; i < N; i++) {
			now_on[i] = now.charAt(i) - '0';
			now_off[i] = now.charAt(i) - '0';
			expect_arr[i] = expect.charAt(i) - '0';
		}

		// turning on first index of the 'now_on'
		now_on[0] = 1 - now_on[0];
		now_on[1] = 1 - now_on[1];

		int ans1 = 1, ans2 = 0;

		for (int i = 1; i < N; i++) {
			// different -> on
			if (now_on[i - 1] != expect_arr[i - 1]) {
				now_on[i - 1] = 1 - now_on[i - 1];
				now_on[i] = 1 - now_on[i];
				ans1++;
				if (i != N - 1)
					now_on[i + 1] = 1 - now_on[i + 1];

			}

			// different -> on
			if (now_off[i - 1] != expect_arr[i - 1]) {
				now_off[i - 1] = 1 - now_off[i - 1];
				now_off[i] = 1 - now_off[i];
				ans2++;
				if (i != N - 1)
					now_off[i + 1] = 1 - now_off[i + 1];
			}
		}

		if (now_on[N - 1] != expect_arr[N - 1])
			ans1 = Integer.MAX_VALUE;
		if (now_off[N - 1] != expect_arr[N - 1])
			ans2 = Integer.MAX_VALUE;

		if (ans1 == Integer.MAX_VALUE && ans2 == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(Math.min(ans1, ans2));
	}
}

// reference: https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-2138-%EC%A0%84%EA%B5%AC%EC%99%80-%EC%8A%A4%EC%9C%84%EC%B9%98-Java