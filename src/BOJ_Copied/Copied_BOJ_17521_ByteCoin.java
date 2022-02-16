package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_17521_ByteCoin {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long w = Integer.parseInt(st.nextToken());
		long coin = 0;
		int[] chart = new int[n];

		for (int i = 0; i < n; i++) {
			chart[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < n - 1; i++) {
			if (chart[i] < chart[i + 1]) { // increase
				if (w >= chart[i]) {
					coin += w / chart[i];
					w %= chart[i];
				}
			} else if (chart[i] > chart[i + 1]) { // decrease
				w += coin * chart[i];
				coin = 0;
			}
		}
		w += coin * chart[n - 1];
		System.out.println(w);
	}
}

// reference: https://velog.io/@humblechoi/%EB%B0%B1%EC%A4%80-17521.-Byte-Coin%EC%8B%A4%EB%B2%845