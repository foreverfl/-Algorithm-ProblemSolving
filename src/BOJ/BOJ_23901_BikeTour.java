package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_23901_BikeTour {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] testCase = new int[T];
		int cnt = 0;

		for (int i = 0; i < T; i++) {
			cnt = 0; // initialization
			testCase[i] = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] tour = new int[testCase[i]];

			for (int j = 0; j < testCase[i]; j++) {
				tour[j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 1; j < testCase[i] - 1; j++) {
				if (tour[j] > tour[j - 1] && tour[j] > tour[j + 1]) {
					cnt++;
				}
			}

			System.out.println("Case #" + (i + 1) + ": " + cnt);

		}

	}

}
