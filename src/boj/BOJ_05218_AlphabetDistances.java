package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_05218_AlphabetDistances {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			String x = st.nextToken();
			String y = st.nextToken();
			int[] arr = new int[x.length()];

			for (int j = 0; j < x.length(); j++) {
				arr[j] = y.charAt(j) - x.charAt(j);

				if (arr[j] < 0)
					sb.append((arr[j] + 26) + " ");
				else
					sb.append(arr[j] + " ");
			}

			System.out.println("Distances: " + sb);

			sb.setLength(0);
		}

	}

}
