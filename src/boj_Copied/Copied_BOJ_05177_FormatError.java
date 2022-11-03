package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_05177_FormatError {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int K = Integer.parseInt(br.readLine());
		int idx = 0;
		while (K-- > 0) {
			idx++;
			String s1 = br.readLine();
			String s2 = br.readLine();

			s1 = parseString(s1);
			s2 = parseString(s2);

			if (s1.equals(s2))
				sb.append("Data Set " + idx + ": equal").append('\n').append('\n');
			else
				sb.append("Data Set " + idx + ": not equal").append('\n').append('\n');

		}

		System.out.println(sb.toString());

	}

	private static String parseString(String str) {
		str = str.toLowerCase();

		str = str.trim();

		str = str.replaceAll("[\\[|\\{]", "(");

		str = str.replaceAll("[\\]|\\}]", ")");

		str = str.replaceAll(";", ",");

		// condition 2 and condition 4
		str = trimSpecialCharacter(trim(str));

		return str;
	}

	private static String trim(String str) {
		StringBuilder sb = new StringBuilder();
		int i, n = str.length();
		char ch;
		for (i = 0; i < n;) {
			sb.append(ch = str.charAt(i++));
			if (ch == ' ')
				while (i < n && str.charAt(i) == ' ')
					i++;
		}
		return sb.toString();
	}

	private static String trimSpecialCharacter(String str) {
		StringBuilder sb = new StringBuilder(str);
		int i, idx, n = sb.length();
		char ch;
		for (i = 0; i < n; i++) {
			ch = sb.charAt(i);
			if (ch == '(' || ch == ')' || ch == ',' || ch == '.' || ch == ':') {
				idx = i - 1;
				if ((0 <= idx && idx < n) && str.charAt(idx) == ' ')
					sb.replace(idx, idx + 1, "*");
				idx = i + 1;
				if ((0 <= idx && idx < n) && str.charAt(idx) == ' ')
					sb.replace(idx, idx + 1, "*");
			}
		}
		return sb.toString().replaceAll("\\*", "");
	}

}

// reference: https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=occidere&logNo=220940030672