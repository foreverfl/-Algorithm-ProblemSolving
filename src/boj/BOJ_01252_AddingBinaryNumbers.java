package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01252_AddingBinaryNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();

		String result = addition(A, B);
		System.out.println(result);
	}

	private static String addition(String a, String b) {

		// processing exception 
		if (!a.contains("1")) {
			a = "0";
		}
		if (!b.contains("1")) {
			b = "0";
		}

		// removing '0'
		if (!a.equals("0")) {
			while (a.charAt(0) != '1') {
				a = a.replaceFirst("0", "");
			}
		}
		if (!b.equals("0")) {
			while (b.charAt(0) != '1') {
				b = b.replaceFirst("0", "");
			}
		}

		int length = a.length() >= b.length() ? a.length() : b.length();

		// matching
		while (a.length() != length) {
			a = "0" + a;
		}
		while (b.length() != length) {
			b = "0" + b;
		}

		String result_pre = "";
		char tmp = '0'; // complement
		for (int i = length - 1; i >= 0; i--) {
			if (a.charAt(i) == '0' && b.charAt(i) == '0' && tmp == '0') {

				result_pre += '0';
				tmp = '0';

			} else if (a.charAt(i) == '0' && b.charAt(i) == '0' && tmp == '1') {

				result_pre += '1';
				tmp = '0';

			} else if (a.charAt(i) == '1' && b.charAt(i) == '1' && tmp == '0') {

				result_pre += '0';
				tmp = '1';

			} else if (a.charAt(i) == '1' && b.charAt(i) == '1' && tmp == '1') {

				result_pre += '1';
				tmp = '1';

			} else if ((a.charAt(i) != b.charAt(i)) && tmp == '0') {

				result_pre += '1';
				tmp = '0';

			} else if ((a.charAt(i) != b.charAt(i)) && tmp == '1') {

				result_pre += '0';
				tmp = '1';

			}

		}

		if (tmp == '1') {
			result_pre += '1';
		}

		StringBuilder sb = new StringBuilder(result_pre);
		String result = sb.reverse().toString();

		return result;
	}

}
