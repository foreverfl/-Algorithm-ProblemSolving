package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_09322_Encryption {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		HashMap<Integer, Integer> index = new HashMap<>();
		HashMap<Integer, String> code = new HashMap<>();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());

			String[] first_public_key = new String[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				first_public_key[i] = st.nextToken();
			}

			String[] second_public_key = new String[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				second_public_key[i] = st.nextToken();
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (first_public_key[i].equals(second_public_key[j])) {
						index.put(j, i);
					}
				}
			}

			st = new StringTokenizer(br.readLine());
			String[] coded_text = new String[n];
			for (int i = 0; i < n; i++) {
				coded_text[i] = st.nextToken();
			}

			for (int i = 0; i < n; i++) {
				code.put(index.get(i), coded_text[i]);
			}

			String[] result = new String[n];
			for (int i = 0; i < n; i++) {
				result[i] = code.get(i);
			}

			for (int i = 0; i < n; i++) {
				sb.append(result[i] + " ");
			}

			sb.append('\n');

			index.clear();
			code.clear();

		}

		System.out.println(sb.toString());
	}

}
