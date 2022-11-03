package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14014_DuDuOfEnglish {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder modifyLines = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			String str = br.readLine();
			str = toDuduWords(str);

			modifyLines.append(str).append('\n');
		}

		String ans = modifyLines.toString();

		String match = "[\n*]";
		ans = ans.replaceAll(match, "");

		match = "[\s*]";
		ans = ans.replaceAll(match, " ");

		StringTokenizer st = new StringTokenizer(ans);
		StringBuilder sb = new StringBuilder();

		int cnt = 0;
		while (st.hasMoreTokens()) {
			String tmp = st.nextToken();
			for (int i = 0; i < tmp.length(); i++) {
				cnt++;
			}
			sb.append(tmp + " ");
			if (cnt > 20) {
				sb.append('\n');
				cnt = 0;
			}
		}

		System.out.println(sb.toString());

	}

	private static String toDuduWords(String str) {
		StringBuilder vowel_setting = new StringBuilder();
		StringBuilder dudu = new StringBuilder();
		StringTokenizer st = new StringTokenizer(str);

		while (st.hasMoreTokens()) {
			String tmp = st.nextToken();
			tmp = tmp.toLowerCase();

			String[] of_words = { "of", "to", "into", "onto", "above", "below", "from", "by", "is", "at" };
			for (int i = 0; i < of_words.length; i++) {
				if (tmp.equals(of_words[i]))
					tmp = "of";
			}

			char[] vowel = { 'a', 'e', 'i', 'o', 'u' }; // printing vowels to the 'K/2'.
			int vowel_cnt = 0;
			for (int i = 0; i < tmp.length(); i++) {
				for (int j = 0; j < vowel.length; j++) {
					if (tmp.charAt(i) == vowel[j])
						vowel_cnt++;
				}
			}
			int vowel_needless = vowel_cnt / 2;

			loop: for (int i = 0; i < tmp.length(); i++) {
				if (vowel_needless > 0) {
					for (int j = 0; j < vowel.length; j++) {
						if (tmp.charAt(i) == vowel[j]) {
							vowel_needless--;
							continue loop;
						}
					}

				}
				vowel_setting.append(tmp.charAt(i));
			}

			tmp = vowel_setting.toString();

			String match = "[^a-zA-Z]";
			tmp = tmp.replaceAll(match, "");

			dudu.append(tmp + " ");

			vowel_setting.setLength(0);
		}

		return dudu.toString();
	}

}
