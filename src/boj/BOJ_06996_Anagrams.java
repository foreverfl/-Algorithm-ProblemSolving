package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_06996_Anagrams {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int[] alphabet_A = new int[26];
			int[] alphabet_B = new int[26];

			st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();

			for (int i = 0; i < A.length(); i++) {
				alphabet_A[A.charAt(i) - 'a'] += 1;
			}

			for (int i = 0; i < B.length(); i++) {
				alphabet_B[B.charAt(i) - 'a'] += 1;
			}

			boolean flag = true;
			for (int i = 0; i < 26; i++) {
				if (alphabet_A[i] != alphabet_B[i])
					flag = false;
			}

			if (flag)
				sb.append(A + " & " + B + " are anagrams.").append('\n');
			else
				sb.append(A + " & " + B + " are NOT anagrams.").append('\n');

		}

		System.out.println(sb.toString());
	}

}
