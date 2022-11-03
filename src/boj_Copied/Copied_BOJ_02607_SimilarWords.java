package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_02607_SimilarWords {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()) - 1;
		String standard = br.readLine();
		int length = standard.length();
		int[] alphabet = new int[26];
		for (int i = 0; i < length; i++) {
			alphabet[standard.charAt(i) - 'A']++;
		}

		int result = 0;
		while (T-- > 0) {
			int[] check = alphabet.clone();
			String comp = br.readLine();
			int cnt = 0;
			for (int i = 0; i < comp.length(); i++) {
				if (check[comp.charAt(i) - 'A'] > 0) {
					cnt++;
					check[comp.charAt(i) - 'A']--;
				}
			}

			if (length - 1 == comp.length() && cnt == comp.length()) { // length - 1
				result++;
			} else if (length == comp.length()) { // length
				if (cnt == length || cnt == length - 1)
					result++;
			} else if (length + 1 == comp.length()) { // length + 1
				if (cnt == length)
					result++;
			}
		}
		System.out.println(result);
	}
}

// reference: https://dundung.tistory.com/131