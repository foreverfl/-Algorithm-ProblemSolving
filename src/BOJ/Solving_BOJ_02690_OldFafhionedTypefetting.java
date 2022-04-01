package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solving_BOJ_02690_OldFafhionedTypefetting {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int P = Integer.parseInt(br.readLine());

		while (P-- > 0) {
			String str = br.readLine();
			Pattern pattern = Pattern.compile("a-zA-Z");
			Matcher matcher = pattern.matcher(str);
			while (matcher.find()) {
				
			}
			str = expressS(str);
			str = ligature(str);
			sb.append(str).append('\n');
		}

		System.out.println(sb.toString());
	}

	private static String expressS(String str) {
		// @ -> s(short)
		// # -> s(long)
		StringBuilder tmp = new StringBuilder(str + " ");

		for (int i = 1; i < tmp.length(); i++) {
			if (tmp.charAt(i) == ' ' || tmp.charAt(i) == '-' || tmp.charAt(i) == '¡¯') {
				if (tmp.charAt(i - 1) == 's') {
					tmp.replace(i - 1, i, "@");
				}
			}
		}

		for (int i = 1; i < tmp.length(); i++) {
			if (tmp.charAt(i) == 'f' || tmp.charAt(i) == 'b' || tmp.charAt(i) == 'k') {
				if (tmp.charAt(i - 1) == 's') {
					tmp.replace(i - 1, i, "@");
				}
			}
		}

		for (int i = 2; i < tmp.length() - 2; i++) {
			if (tmp.charAt(i) == 's' && tmp.charAt(i + 1) == 's') {
				if (tmp.charAt(i + 2) == 's') {
					tmp.replace(i + 1, i + 2, "@");
					tmp.replace(i, i + 1, "#");
					tmp.replace(i + 2, i + 3, "#");
				}
			}
		}

		String result = tmp.toString();
		result = result.replaceAll("s", "#");

		return result;
	}

	private static String ligature(String str) {
		// 3 characters - 2
		str = str.replaceAll("ffi", "[ffi]");
		str = str.replaceAll("ffl", "[ffl]");
		str = str.replaceAll("##i", "[longssi]");

		// 2 characters - 13
		str = str.replaceAll("AE", "[AE]");
		str = str.replaceAll("Ae", "[AE]");

		str = str.replaceAll("ae", "[ae]");
		str = str.replaceAll("aE", "[ae]");

		str = str.replaceAll("OE", "[OE]");
		str = str.replaceAll("Oe", "[OE]");

		str = str.replaceAll("oe", "[oe]");
		str = str.replaceAll("oE", "[oe]");

		str = str.replaceAll("ct", "[ct]");
		str = str.replaceAll("ff", "[ff]");
		str = str.replaceAll("fi", "[fi]");
		str = str.replaceAll("fl", "[fl]");
		str = str.replaceAll("#i", "[longsi]");
		str = str.replaceAll("#h", "[longsh]");
		str = str.replaceAll("#l", "[longsl]");
		str = str.replaceAll("##", "[longss]");
		str = str.replaceAll("#t", "[longst]");

		// 1 character
		str = str.replaceAll("@", "s");
		str = str.replaceAll("#", "[longs]");

		return str;
	}

}
