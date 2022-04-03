package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_06493_Slurpys {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

//		sb.append("SLURPYS OUTPUT").append('\n');

		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			String input = br.readLine();
			int lastIdxOfC = input.lastIndexOf('C');
			if (lastIdxOfC != -1) { // If the 'slimp' is longer than 3.
				if (isSlimp(input.substring(0, lastIdxOfC + 1)) && isSlump(input.substring(lastIdxOfC + 1))) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}

			} else { // If the 'slimp' is shorter than 2.
				if (input.startsWith("AH") && isSlump(input.substring(2))) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}

//		sb.append("END OF OUTPUT").append('\n');

		System.out.println(sb.toString());
	}

	private static boolean isSlump(String str) {
		return str.matches("^([DE]F+)+G$");
	}

	private static boolean isSlimp(String str) {
		if (str.length() < 2) {
			return false;
		}

		if (str.length() == 2 && str.equals("AH")) {
			return true;
		}

		if (str.charAt(0) == 'A' && str.charAt(str.length() - 1) == 'C') {
			if (str.charAt(1) == 'B') {
				return isSlimp(str.substring(2, str.length() - 1));
			} else {
				return isSlump(str.substring(1, str.length() - 1));
			}
		}

		return false;
	}

}
