package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solving_BOJ_13040_ImportantTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int t0 = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			Integer[] arr = new Integer[m];
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < m; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				max = Math.max(arr[j], max);
			}

			for (int j = 0; j < m; j++) {
				if (max == arr[j] && max > t0) {
					arr[j] = t0;
					break;
				}
			}

			int ans = 0;
			int now = 0;
			for (int j = 0; j < m; j++) {
				now += arr[j];
				ans++;

				if (now > t) {
					ans--;
					break;
				}
			}

			sb.append(ans).append('\n');

		}

		System.out.println(sb.toString());

	}

}
