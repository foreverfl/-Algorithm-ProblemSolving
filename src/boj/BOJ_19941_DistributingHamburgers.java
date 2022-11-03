package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19941_DistributingHamburgers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder(br.readLine());

		int cnt = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == 'P') {
				sb.replace(i, i + 1, "0");
				int start = i - K;
				int end = i + K;

				// processing error
				if (i - K < 0)
					start = 0;

				if (i + K >= sb.length())
					end = sb.length() - 1; // Without the '-1', the 'outofexception' occurs.

				for (int j = start; j <= end; j++) {
					if (sb.charAt(j) == 'H') {
						cnt++;
						sb.replace(j, j + 1, "X");
						break;
					}
				}

			} else
				continue;
		}

		System.out.println(cnt);
	}

}
