package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01201_NMK {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		System.out.println(findProgression(n, m, k));
	}

	private static String findProgression(int n, int m, int k) {
		if (m + k - 1 > n || m * k < n) {
			return "-1";
		}

		int[] groupSize = new int[m];
		groupSize[0] = k; // size of the first group
		n -= k;

		if (m - 1 > 0) {
			// m - 1 -> excluding the first group
			int div = n / (m - 1); // basic size
			int remain = n % (m - 1); // re-assigning the remains

			for (int i = 1; i < m; i++) {
				if (remain-- > 0) {
					groupSize[i] = div + 1;
				} else {
					groupSize[i] = div;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int startIdx = 0, endIdx = 0;
		for (int i = 0; i < m; i++) {
			startIdx = endIdx;
			endIdx += groupSize[i];
			for (int j = endIdx - 1; j >= endIdx - groupSize[i]; j--) {
				sb.append((j + 1) + " ");
			}
		}

		return sb.toString();
	}

}

// reference: https://gre-eny.tistory.com/287
