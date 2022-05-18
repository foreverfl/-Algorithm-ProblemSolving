package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01052_WaterBottle {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int ans = 0;
		if (N <= K)
			ans = 0;

		else {
			int bottle = 0;
			while (true) {
				int cnt = 0;
				int num = N;
				while (num != 0) {
					if (num % 2 == 1)
						cnt++;
					num /= 2;
				}

				if (cnt <= K) {
					break;
				}
				bottle++;
				N++;
			}
			ans = bottle;
		}

		System.out.println(ans);
	}

}

// reference: https://www.google.com/search?q=%EB%B0%B1%EC%A4%80+1052+%EC%9E%90%EB%B0%94&oq=%EB%B0%B1%EC%A4%80+1052+%EC%9E%90%EB%B0%94&aqs=chrome..69i57j0i30l2.4217j1j7&sourceid=chrome&ie=UTF-8